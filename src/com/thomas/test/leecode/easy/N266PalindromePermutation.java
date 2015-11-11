package com.thomas.test.leecode.easy;

import java.util.HashSet;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.

   For example, "code" -> False, "aab" -> True, "carerac" -> True.

    Hint:

Consider the palindromes of odd vs even length. What difference do you notice? Count the frequency of each character. If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?

 *给定一个字符串,判断字符串的排列可以组成一个回文。
 *例如, "code" -> False, "aab" -> True, "carerac" -> True.
 *考虑奇数和偶数长度的回文。
 *你注意到有什么不同呢?计算每个字符的频率。
 *如果每个字符出现的偶数次数,那么它必须是一个回文。出现奇数次会怎么样呢?
 * @author thomas
 * @time :2015年10月28日下午4:28:35
 */
public class N266PalindromePermutation {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("223322"));
	}
	
	public static boolean isPalindrome(String src){
		char srcChars[] = src.toCharArray();
		HashSet<Character> set = new HashSet<Character>();
		for(char sc : srcChars){
			if(set.contains(sc)){
				set.remove(sc);
			}else{
				set.add(sc);
			}
		}
		if(srcChars.length % 2 > 0)
			 return set.size() == 1;
		else
			return set.size() == 0;
	}
}
