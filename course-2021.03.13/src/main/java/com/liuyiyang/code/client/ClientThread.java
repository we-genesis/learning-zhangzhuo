package com.liuyiyang.code.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ClientThread implements Runnable {
    // ���߳��������Socket����Ӧ��������
    BufferedReader br = null;
    // ���̸߳������Socket
    private Socket s;

    public ClientThread(Socket s)
            throws IOException {
        this.s = s;
        br = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
    }

    public void run() {
        try {
            String content = null;
            // ���϶�ȡSocket�������е����ݣ�������Щ���ݴ�ӡ���
            while ((content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
