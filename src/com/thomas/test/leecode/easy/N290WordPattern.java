package com.thomas.test.leecode.easy;

import java.util.HashMap;

import com.sun.org.apache.xalan.internal.utils.Objects;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * @author thomas
 * @time :2015年11月10日下午6:29:34
 */
public class N290WordPattern {
	
	public static void main(String[] args) {
		System.out.println(isPattern("abba", "w bbb bbb w"));
	}
	
	//考虑不周，如下情况返回不对pattern = "abba", str = "dog dog dog dog" should return true.
	public static boolean isPattern(String pattern,String str){
		if(null == pattern || null == str)
			return false;
		String[] srcAry = str.split(" ");
		if(pattern.length() != srcAry.length)
			return false;
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int length = srcAry.length;
		for(int i = 0 ;i < length;i++){
			if(!Objects.equals(map.put(pattern.charAt(i)+"", i), map.put(srcAry[i], i)))
				return false;
		}
		return true;
	}
}
