package com.study.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description tcp客户端
 * @date 2018/12/6
 * 发送数据之前建立三次握手
 * 四次拜拜
 */
public class TcpClient {

    public void tcpClient() throws IOException{

        Socket socket=new Socket("192.168.5.241",8080);
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write("asdads".getBytes());
        socket.close();

        }


}
