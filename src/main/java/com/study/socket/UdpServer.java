package com.study.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.security.spec.DSAGenParameterSpec;

/**
 * @description udp服务端
 * @date 2018/12/6
 */
public class UdpServer {

    public void udpServer() throws SocketException, IOException {

        DatagramSocket datagramSocket = new DatagramSocket(8080);
        byte[] buf = new byte[1024];
        //阻塞
        DatagramPacket ds = new DatagramPacket(buf, buf.length);
        datagramSocket.receive(ds);

        String str = new String(ds.getData(), 0, ds.getLength());
        datagramSocket.close();


    }
}
