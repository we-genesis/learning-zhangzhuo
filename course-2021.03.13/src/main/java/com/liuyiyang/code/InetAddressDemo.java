package com.liuyiyang.code;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        // public static InetAddress getByName(String host)
        // InetAddress address = InetAddress.getByName("liuyi");
        // InetAddress address = InetAddress.getByName("192.168.12.92");
        InetAddress address = InetAddress.getLocalHost();
        // 获取两个东西：主机名，IP地址
        // public String getHostName()
        String name = address.getHostName();
        // public String getHostAddress()
        String ip = address.getHostAddress();
        System.out.println(name + "---" + ip);
    }
}
