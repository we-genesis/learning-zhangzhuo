package com.liuyiyang.code;

/**
 * 第一题，某某公司开发一个编程工具，用来给代码自动生成注释，其中一个功能点，是把驼峰命名转为英文句子：
 * 例如某驼峰命名为：
 * getSystemResourceAsStream
 * 程序需要把该字符串转换为如下格式：
 * get system resource as stream
 * 顺便，做个单词翻转，最后输出：
 * teg metsys ecruoser sa maerts
 * 程序的原始输入就是标准的Java标识符
 * 可能包含数字、大小写字母、下划线，下划线直接转为空格，数字两边都加空格，大写字母的前面加空格，只要单空格不要双空格
 */
public class SymbolToEnglish {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String aString = "getSystemResourceAsStream";
        for (int i = 0; i < aString.length(); i++) {
            char charAt = aString.charAt(i);
            if (charAt >= 'A' && charAt <= 'Z') {
                // 大写字母转为小写，前面加空格
                sb.append(" " + String.valueOf((char) (charAt + 'a' - 'A')));
            } else if (charAt >= '0' && charAt <= '9') {
                // 数字怎么处理？两边都加空格
                sb.append(" " + String.valueOf(charAt) + "");
            } else if (charAt == '_') {
                // 下划线直接转化为空格
                sb.append(" ");
            } else if (charAt >= 'a' && charAt <= 'z') {
                // 小写字母不变
                sb.append(String.valueOf(charAt));
            }
        }
        String[] strings = sb.toString().replace("  ", " ").split(" ");
        for (int i = 0; i < strings.length; i++) {
            // get
            strings[i] = new StringBuilder(strings[i]).reverse().toString();
            if (i == strings.length - 1) {
                System.out.print(strings[i]);
            } else {
                System.out.print(strings[i] + " ");
            }
        }
        System.out.println();
        // get system resource as stream
        // teg metsys ecruoser sa maerts
    }
}
