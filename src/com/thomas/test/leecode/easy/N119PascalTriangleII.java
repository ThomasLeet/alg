package com.thomas.test.leecode.easy;

/**
 * 判断一个整数是一个回文。不用额外的空间。
 * 不能转化为字符串，因为字符串需要额外空间。
 * @author thomas
 * @time :2015年11月6日下午4:19:10
 */
public class N119PascalTriangleII {
	
	public static void main(String[] args) {
		System.out.println(ispascal(1234324));
	}
	
	public static boolean ispascal(int src){
		if(src != 0 && src%10 == 0)
			return false;
		int reverseInt = 0;
		while(src > reverseInt){
			reverseInt = reverseInt*10 + src % 10;
			src /=10;
		}
		return reverseInt == src || reverseInt / 10 == src;
	}
}
