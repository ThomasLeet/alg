package com.thomas.test.leecode.easy;
/**
 * 给定一个非负整数num,反复相加所有的数字,直到结果只有一个数字。 
 * 例如:
 * 鉴于num = 38,这个过程是:3 + 8 = 11,1 + 1 = 2。因为2只有一个数字,返回它。
 * 要求：
 * 你能做到没有任何循环/递归在O(1)运行时?
 * @author thomas
 * @time :2015年10月28日下午3:51:04
 */
public class N258AddDigits {
	
	public static void main(String[] args) {
		System.out.println(addDigit(123870986));
	}
	
	/**
	 * 找规律，从1开始一个一个看。
	 * @param number
	 * @return
	 */
	public static int addDigit(int number){
		return 13496 % 9;
	}
}
