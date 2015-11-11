package com.thomas.test.leecode.easy;

/**
 * 给定一个字符串 s 由大/小写字母和“ ”,返回字符串中的最后一个词的长度。
 * 如果没有最后一个单词返回0；
 * 每个词用空格相隔;
 * s = "Hello World",
 * return 5.
 * @author thomas
 * @time :2015年11月10日下午2:33:15
 */
public class N58LengthofLastWord {
	
	public static void main(String[] args) {
		System.out.println(length("asdfas hello "));
	}
	
	public static int length(String word){
		return word.length()-1 - word.lastIndexOf(" ");
	}
}
