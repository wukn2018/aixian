package com.example.demo.web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class ServiceDemo {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket( 8888 );
        System.out.println("服务器启动成功.............");

        Socket socket = serverSocket.accept();
        if(socket == null) {
            System.out.println("连接失败------");
        }
        System.out.println("连接成功--------");
        System.out.println("连接地址和端口号---"+socket.getInetAddress() + socket.getPort());
        BufferedReader bufferedReader = getBufferedReader(socket);
        PrintWriter printWriter = getPrintWriter(socket);
        String message = null;
        while ((message = bufferedReader.readLine()) != null) {
            System.out.println("接受消息----"+message);
            printWriter.println( "收到消息消息:"+""+message);
            if(message.equals( "bye" )) {
                break;
            }
        }
        socket.close();
    }





    /**
     *
     * @return
     */
    public static PrintWriter getPrintWriter(Socket socket) throws Exception{
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter( outputStream,true );
        return printWriter;
    }


    /**
     *
     * @return
     */
    public static BufferedReader getBufferedReader(Socket socket) throws Exception{
        BufferedReader bufferedReader;
        try (InputStream inputStream = socket.getInputStream( )) {
            bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
        }
        return bufferedReader;
    }


}
