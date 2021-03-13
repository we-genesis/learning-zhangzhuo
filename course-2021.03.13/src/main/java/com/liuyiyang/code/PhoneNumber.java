package com.liuyiyang.code;

import java.util.*;

/**
 * 几种语言：
 * english、chinese、number、pinyin
 * zero one two three four five six seven eight nine
 * 零   一  二  三    四   五   六  七    八    九
 * 0    1   2   3     4     5    6   7    8     9
 * ling yi  er  san  si   wu    liu  qi   ba   jiu
 * <p>
 * 用户的输入：
 * 第一行：要翻译的文本，假定是正常文本，不存在错误文本
 * 第二行：源语言
 * 第三行：目标语言
 * <p>
 * 四种语言分类：
 * 数字和汉字都是不用隔开输出的
 * 拼音和英文都是要用空格隔开、方便阅读
 */
public class PhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 要翻译的文本
        String originText = sc.nextLine();
        // 源语言
        String originLanguage = sc.nextLine();
        // 目标语言
        String targetLanguage = sc.nextLine();
        // 如果目标语言等于源语言，输出原文，如果源语言不能识别或目标语言不能识别，也输出原文
        if (originLanguage.equals(targetLanguage) ||
                (!originLanguage.equals("english") && !originLanguage.equals("chinese") && !originLanguage.equals("number") && !originLanguage.equals("pinyin")) ||
                (!targetLanguage.equals("english") && !targetLanguage.equals("chinese") && !targetLanguage.equals("number") && !targetLanguage.equals("pinyin"))) {
            System.out.println(originText);
            return;
        }

        // 翻译
        List<String> targetWordList = translate(originText, originLanguage, targetLanguage);

        // 按不同语言的阅读习惯输出
        if (targetLanguage.equals("number") || targetLanguage.equals("chinese")) {
            print(targetWordList, "");
        } else if (targetLanguage.equals("english") || targetLanguage.equals("pinyin")) {
            print(targetWordList, " ");
        }
    }

    public static List<String> translate(String originText, String originLanguage, String targetLanguage) {
        // 不同语言的单词列表
        List<String> wordList = new ArrayList<String>();
        if (originLanguage.equals("number") || originLanguage.equals("chinese")) {
            for (int i = 0; i < originText.length(); i++) {
                wordList.add(originText.charAt(i) + "");
            }
        } else if (originLanguage.equals("english") || originLanguage.equals("pinyin")) {
            String[] wordArray = originText.split(" ");
            for (int i = 0; i < wordArray.length; i++) {
                wordList.add(wordArray[i]);
            }
        }

        // 数组
        String[] englishWord = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numberWord = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] pinyinWord = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
        String[] chineseWord = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

        // 通过单词，获得当前单词的角标
        Map<String, Integer> englishMap = new HashMap<String, Integer>();
        Map<String, Integer> numberMap = new HashMap<String, Integer>();
        Map<String, Integer> pinyinMap = new HashMap<String, Integer>();
        Map<String, Integer> chineseMap = new HashMap<String, Integer>();
        for (int i = 0; i < englishWord.length; i++) {
            englishMap.put(englishWord[i], i);
        }
        for (int i = 0; i < numberWord.length; i++) {
            numberMap.put(numberWord[i], i);
        }
        for (int i = 0; i < pinyinWord.length; i++) {
            pinyinMap.put(pinyinWord[i], i);
        }
        for (int i = 0; i < chineseWord.length; i++) {
            chineseMap.put(chineseWord[i], i);
        }

        List<String> targetWordList = new ArrayList<String>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            int index = 0;
            if (originLanguage.equals("english")) {
                index = englishMap.get(word);
            } else if (originLanguage.equals("number")) {
                index = numberMap.get(word);
            } else if (originLanguage.equals("pinyin")) {
                index = pinyinMap.get(word);
            } else if (originLanguage.equals("chinese")) {
                index = chineseMap.get(word);
            }
            if (targetLanguage.equals("english")) {
                targetWordList.add(englishWord[index]);
            } else if (targetLanguage.equals("number")) {
                targetWordList.add(numberWord[index]);
            } else if (targetLanguage.equals("pinyin")) {
                targetWordList.add(pinyinWord[index]);
            } else if (targetLanguage.equals("chinese")) {
                targetWordList.add(chineseWord[index]);
            }
        }
        return targetWordList;
    }

    // QQ -> 网卡驱动(网卡软件) -> 操作系统 -> (CPU(芯片)、BUS数据总线(主板)、缓存(内存)) -> 网卡硬件 -> 电信号 -> 网线 -> 路由器 -> 网线 -> 光猫 -> 光纤 -> 核心网 -> 腾讯服务器 -> QQ server -> 你要发给那个用户？
    // ip地址与子网掩码做位与运算，结果一致，说明在同一个子网
    // 192.168.43.17 255.255.255.0               192.168.43.18                                 192.168.44.18
    // 11000000 10101000 00101011 00010001
    // 11111111 11111111 11111111 00000000
    // 11000000 10101000 00101011 00000000
    // 192.168.43.0                              192.168.43.0 在同一个子网，能互相通信         192.168.44.0
    // 192.168.43.0

    // 电脑 <-> 电脑   直连通信要在同一个子网
    // 子网 <-Internet(寻址、路由)-> 子网
    // 子网分级
    // 电脑 <-> 核心网 <-> 国外的电脑 <-> 国外的核心网
    // 电脑 <-> 核心网 <-> 国外的核心网 会被拦截
    public static void print(List<String> targetWordList, String spilt) {
        for (int i = 0; i < targetWordList.size(); i++) {
            System.out.print(targetWordList.get(i) + spilt);
        }
        System.out.println();
    }
}
