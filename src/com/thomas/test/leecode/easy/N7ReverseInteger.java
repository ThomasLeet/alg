package com.thomas.test.leecode.easy;

/**
 * Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
 * @author thomas
 * @time :2015年11月12日下午5:58:19
 */
public class N7ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverseInt(-119945849));
	}
	
	public static int reverseInt(int src){
		int newInt = 0;
		while(src != 0){
			int oldResult = newInt;
			newInt = newInt*10 + src % 10;
			if(newInt / 10 != oldResult)
				return 0;
			src /= 10;
		}
		return newInt;
	}
}
