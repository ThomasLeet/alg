package com.thomas.test.leecode.easy;

/**
 * 给定一个整数,写一个函数来确定它是2的幂。
 * @author thomas
 * @time :2015年11月4日下午1:59:49
 */
public class N231PowerofTwo {
	
	public static void main(String[] args) {
		System.out.println(isPowerOfTwoNice(129));
	}

	/**
	 * 自己解法
	 * @param src
	 * @return
	 */
	public static boolean isPowerOfTwo(int src){
		if(src <= 0)
			return false;
		String binary = Integer.toBinaryString(src);
		int length = binary.length();
		for(int i= 1;i< length;i++){
			if(binary.charAt(i) != '0')
				return false;
		}
		return true;
	}
	
	public static boolean isPowerOfTwoNice(int src){
		if(src <= 0)
			return false;
		return (src&(src-1)) == 0;
	}
}
