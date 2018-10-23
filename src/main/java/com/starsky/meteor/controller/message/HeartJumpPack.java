package com.starsky.meteor.controller.message;

import com.alibaba.fastjson.JSONObject;
import com.starsky.meteor.bean.HeartJump;

import java.io.*;

public class HeartJumpPack {
//    private int packLength;
//    private String heartJumpJsonString;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public HeartJumpPack(HeartJump heartJump) {

    }

    public HeartJumpPack(){
    }

    public void balePack(OutputStream outputStream,HeartJump heartJump) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("heartJump",heartJump);
        String heartJumpJsonString = jsonObject.toJSONString();
        System.out.println(heartJumpJsonString);
        int packLength=heartJumpJsonString.length();

        dataOutputStream = new DataOutputStream(outputStream);
        try {
//            dataOutputStream.write(packLength);
            byte[] packLengthByte = Conversion.intToByteArray(packLength);
            dataOutputStream.write(packLengthByte);
            dataOutputStream.write(heartJumpJsonString.getBytes());
        }catch (IOException e){
            throw new IOException();
        }
    }

    public void analysisPack(InputStream inputStream) throws IOException {
        byte[] packLengthByte=new byte[4];
        dataInputStream = new DataInputStream(inputStream);
        try {
            dataInputStream.read(packLengthByte);
            int i = Conversion.byteArrayToInt(packLengthByte);
            System.out.println(i);
            byte[] messageBodyByte=new byte[i];
            int read = dataInputStream.read(messageBodyByte);
            System.out.println(read);
            String s = new String(messageBodyByte);
            System.out.println(s);
        }catch (IOException e) {
            throw new IOException();
        }
    }

    public void close(){
        try {
            dataInputStream.close();
            dataOutputStream.close();
        }catch (IOException e){
            System.out.println("网络通信关闭异常");
        }
    }

}
