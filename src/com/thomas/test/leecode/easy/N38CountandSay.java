package com.thomas.test.leecode.easy;

import java.util.Arrays;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * 第i+1个字符串是第i个字符串的读法，第一字符串为 “1”
 * 比如第四个字符串是1211，它的读法是 1个1、1个2,2个1，因此第五个字符串是111221。
 * 第五个字符串的读法是：3个1、2个2、1个1，因此第六个字符串是312211      
 * @author thomas
 * @time :2015年11月11日下午2:32:26
 */
public class N38CountandSay {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(say(6)));
	}
	
	public static long[] say(int n){
		int result = 1;
		int count = 0;
		Integer lastNumber = -1;
		long[] rstAry = new long[n];
		StringBuilder resultTem = new StringBuilder();
		rstAry[0] = 1;
		for(int i = 1 ; i < n ;i++){
			resultTem.delete(0, resultTem.capacity());
			while(result % 10 > 0){
				if(lastNumber == result % 10){
					count++;
				}else{
					if(lastNumber != -1){
						resultTem.insert(0, count+""+lastNumber);
					}
					lastNumber = result % 10;
					count = 1;
				}
				result = result / 10;
			}
			resultTem.insert(0, count+""+lastNumber);
			rstAry[i] = result = Integer.parseInt(resultTem.toString()); 
			count = 0;
			lastNumber = -1;
		}
		return rstAry;
	}
}
