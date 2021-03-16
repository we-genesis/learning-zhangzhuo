package com.liuyiyang.code;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 概率计算，0-9十个数字，任意选取几个，组成一个ip地址，每个数字可以重复使用，请计算一共能组成多少个不同的ip地址？
 * 选取的数字从键盘输入，例如输入1，那么1、11、111三种，3^4=81
 * <p>
 * 192.168.12.16
 * 0.0.0.0 - 255.255.255.255
 * 00000000 00000000 00000000 00000000    11111111 11111111 11111111 11111111
 * 如果第一段有X种，那么，IP的总个数 = X^4
 * 0-255 这256个数字，我一共能组成多少个？求X
 * 我现在有0 2 4这三个数
 * 1位        2位        3位
 * 0-9        10-99      100-255
 * <p>
 * 1位的：0 2 4 三种
 * 2位的：20 40 24 42 22 44 六种
 * 3位的：第一位只能是2，九种
 * <p>
 * 18^4 = 答案，最大的时候答案会超出int的表示范围
 */
public class IpAddress {
    public static void main(String[] args) throws IOException {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(256 * 256 * 256 * 256);
        Properties properties = new Properties();
        properties.load(IpAddress.class.getClassLoader().getResourceAsStream("properties.properties"));
        System.out.println(properties.getProperty("chinese.0"));
    }
}
