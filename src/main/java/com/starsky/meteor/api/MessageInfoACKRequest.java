package com.starsky.meteor.api;

import com.starsky.meteor.bean.HeartJump;
import com.starsky.meteor.controller.message.HeartJumpPack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageInfoACKRequest {

    private static final int PORT=8080;

    private final ServerSocket serverSocket;
    private final Socket client;
    private InputStream inputStream;
    private OutputStream outputStream;

    public MessageInfoACKRequest() throws IOException {
        serverSocket = new ServerSocket(PORT);
        client = serverSocket.accept();
    }

    public void getHeartJumpPack(String userId,String localMessageNum) {
        try {
            HeartJump heartJump = new HeartJump(userId, localMessageNum);
            HeartJumpPack heartJumpPack = new HeartJumpPack();

            inputStream = client.getInputStream();
            heartJumpPack.analysisPack(inputStream);

            outputStream = client.getOutputStream();
            heartJumpPack.balePack(outputStream,heartJump);

            closeClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeClient(){
        try {
            inputStream.close();
            outputStream.close();
            client.close();
        }catch (IOException e){
            System.out.println("关闭异常");
        }
    }
}
