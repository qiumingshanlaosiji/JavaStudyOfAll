package com.study.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @description socket客户端
 * @date 2018/12/6
 */
public class UdClient {

    public  void  udpClient() throws IOException {
        DatagramSocket ds=new DatagramSocket();
        String str="12123";
        byte[] bt=str.getBytes();
        DatagramPacket dp=new DatagramPacket(bt,bt.length, InetAddress.getByName("192.168.5.241"),8080);
        ds.send(dp);
        ds.close();


    }
}
