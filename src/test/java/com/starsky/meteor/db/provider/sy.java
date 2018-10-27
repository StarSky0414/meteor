package com.starsky.meteor.db.provider;


import org.junit.jupiter.api.Test;
import sun.plugin.javascript.navig.Array;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class sy {

    private final static String filePath = "C:\\Users\\starsky\\Desktop\\test.txt";
    private ArrayList<String> customerName = new ArrayList<>();
    private ArrayList<String> phone= new ArrayList<>();
    private ArrayList<String> address= new ArrayList<>();
    private ArrayList<String> email= new ArrayList<>();


    private InputStream openFile() throws FileNotFoundException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        return fileInputStream;
    }

    @Test
    public void test() {
        char[] chars = new char[40];
        InputStream inputStream = null;
        try {
            inputStream = openFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件打开异常，请查看文件路径是否正确");
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            int read = 0;
            while ((read = bufferedReader.read(chars, 0, 2)) != -1) {
                switch (chars[1]) {
                    case '1':
                        bufferedReader.read(chars, 0, 20);
                        customerName.add(new String(chars).replace("_",""));
                        break;
                    case '2':
                        bufferedReader.read(chars, 0, 15);
                        phone.add(new String(chars).replace("_",""));
                        break;
                    case '3':
                        bufferedReader.read(chars, 0, 20);
                        address.add(new String(chars).replace("_",""));
                        break;
                    case '4':
                        bufferedReader.read(chars, 0, 20);
                        email.add(new String(chars).replace("_",""));
                        break;
                }
            }
            System.out.println("Customer name:");
            for (String s : customerName) {
                System.out.println(s);
            }

            System.out.println("Phone:");
            for (String s : phone) {
                System.out.println(s);
            }

            System.out.println("Address:");
            for (String s : address) {
                System.out.println(s);
            }

            System.out.println("Email:");
            for (String s : email) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
