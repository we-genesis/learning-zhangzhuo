package com.liuyiyang.code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 某程序运行产生一堆日志，日志的格式如下，分成四段，模块名，日志级别，时间，内容：
 * [module_name] [level] [time] content
 * 其中日志级别有四级：debug、info、warn、error
 * time的格式是：yyyy-MM-dd HH:mm:ss.SSS，例如:2019-12-31 23:45:03.237
 * 程序的功能是：
 * 对多行日志进行分类，首先按模块名分类，同模块名时，按日期分类，分别写入不同的文件，文件名为module_name-date.log
 * 例如server-2014-03-25.log
 * 与此同时，将原日志输出到命令行，并已黄色高亮显示warn级别的日志，红色高亮显示error级别的日志
 * 日志由用户从键盘输入
 * 日志输入默认假定，时间time是逐行递增的
 * 不懂的百度，如何读写文件，如何输出带颜色的字体
 * 分类，能用Map+List复合结构就用，不会用的话，就想办法，例如文件+if
 */
public class LoggerHelper {
    public static void main(String[] atgs) throws IOException {

        List<String> logList = new ArrayList<String>();
        logList.add("[server] [warn] [2019-12-31 23:45:03.237] 日志内容，程序发生了什么事×××");
        logList.add("[client] [warn] [2019-12-31 23:45:03.237] 日志内容，程序发生了什么事×××");
        logList.add("[client] [warn] [2019-12-31 23:45:03.237] 日志内容，程序发生了什么事×××");
        logList.add("[server] [warn] [2021-03-16 23:45:03.237] 日志内容，程序发生了什么事×××");
        for (int i = 0; i < logList.size(); i++) {
            String currentLog = logList.get(i);
            String[] fenzuLog = currentLog.split(" ");
            // [server] [warn] [2019-12-31
            String moduleName = fenzuLog[0].substring(1, fenzuLog[0].length() - 1);
            String data = fenzuLog[2].substring(1, fenzuLog[2].length());
            String fileName = moduleName + "-" + data + ".log";
            File file = new File(fileName);
            if (file.exists()) {
                FileWriter wr = new FileWriter(file, true);
                wr.write(currentLog + "\n");
                wr.flush();
            } else {
                file.createNewFile();
                FileWriter wr = new FileWriter(file, true);
                wr.write(currentLog + "\n");
                wr.flush();
            }
        }
        System.out.println("\033[35;4m" + "我滴个颜什" + "\033[0m");
    }
}
