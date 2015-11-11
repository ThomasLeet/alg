package com.thomas.test.leecode.easy;

/**
 * 鉴于两个字符串s和t,编写一个函数来确定t是s的一个anagram（相同字母异序，变位词）。
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 注：
 * 你可能认为字符串只包含小写字母。
 * 
 * 如果输入包含unicode字符呢?你会如何解决方案适应这样的情况?
 * @author thomas
 * @time :2015年10月30日下午1:51:51
 */
public class N242ValidAnagram {
	//26个字母，可以用hashset存，然后比较(否定)
	//比较好的办法
	public static boolean anagram(String s1,String s2){
		if(null == s1 || null == s2 || s1.length() != s2.length())
			return false;
		int[] letter = new int[26];
		for(int i = 0 ; i<s1.length();i++){
			letter[s1.charAt(i)-'a']++;
			letter[s2.charAt(i)-'a']--;
		}
		for(int l : letter){
			if(l != 0)
				return false;
		}
		return true;
	} 
	/**
	 * 如果是unicode的话，字符不多的情况 就用HashSet对每个字存储然后比较。
	 * 如果比较的字符串很长呢？
	 * 如果是很多字符中找到一样的就给每个字符串排序，然后用排序后的词作为hashmap的key，value是linkedlist，
	 * 链表中都是相同变位词的字符串。
	 * @param args
	 */
	
	public static void main(String[] args) {
		System.out.println(anagram("sstop","potss"));
	}
}
