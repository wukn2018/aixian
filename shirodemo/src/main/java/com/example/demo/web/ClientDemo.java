package com.example.demo.web;

import java.io.*;
import java.net.Socket;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class ClientDemo {

    private static int port = 8888;
    private static String ip = "localhost";
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket( ip , port );
        System.out.println("开始连接--------");
        if(socket != null) {
            System.out.println("客户端连接成功----------");
        }
        BufferedReader bufferedReader = getBufferedReader(socket);
        PrintWriter printWriter = getPrintWriter(socket);
        //获取输入的的内容
        System.out.println("Enter your value:");
        BufferedReader local = new BufferedReader( new InputStreamReader( System.in ) );
        String message = null;
        while ((message = local.readLine()) != null) {
            printWriter.println( message );
            System.out.println(bufferedReader.readLine());
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
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
        return bufferedReader;
    }
}
