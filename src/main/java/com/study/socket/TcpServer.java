package com.study.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description tcp服务端
 * @date 2018/12/6
 */
public class TcpServer {

    public void tcpServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] buf = new byte[1024];
        int len=inputStream.read(buf);
        String str = new String(buf, 0, len);
        serverSocket.close();
    }
}
