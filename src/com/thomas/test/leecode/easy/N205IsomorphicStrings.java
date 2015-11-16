package com.thomas.test.leecode.easy;

import java.util.HashMap;

/**
 * 给定两个字符串 s and t,判断是否是同构词。
 * 两个字符不能map到同一字符，但是字符可以map为自己。
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * 注意：
 * 假设两个字符有相同的长度
 * @author thomas
 * @time :2015年11月11日上午10:35:11
 */
public class N205IsomorphicStrings {
	
	public static void main(String[] args) {
		System.out.println(isIsomorphicNice("add","acc"));
	}
	//自己
	public static boolean isIsomorphic(String src1, String src2){
		if(null == src1 || null == src2 || src1.length() != src2.length())
			return false;
		if(src1.equals(src2))
			return true;
		HashMap<Character,Character> set1 = new HashMap<Character,Character>();
		HashMap<Character,Character> set2 = new HashMap<Character,Character>();
		for(int i=0 ;i< src1.length(); i++){
			Character oldSrc2 = set1.put(src1.charAt(i),src2.charAt(i));
			if(null != oldSrc2 && oldSrc2.charValue() != src2.charAt(i))
				return false;
			Character oldSrc1 = set2.put(src2.charAt(i), src1.charAt(i));
			if(null !=oldSrc1 && oldSrc1.charValue() != src1.charAt(i))
				return false;
		}
		return true;
	}
	
	
	public static boolean isIsomorphicNice(String src1,String src2){
		if(null == src1 || null == src2 || src1.length() != src2.length())
			return false;
		int[] map = new int[512];
		int length = src1.length();
		for(int i =0;i < length;i++){
			if(map[src1.charAt(i)] != map[src2.charAt(i)+256])
				return false;
			map[src1.charAt(i)] = map[src2.charAt(i)+256] = i+1;
		}
		return true;
	}
}
