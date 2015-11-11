package com.thomas.test.leecode.easy;

/**
 * 给定一个出现在Excel表的列标题,返回相应的列号。
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28 
 *  可以说这个就是26进制转换10进制
 * @author thomas
 * @time :2015年10月29日下午5:48:01
 */
public class N171ExcelSheetColumnNumber {
	
	public static void main(String[] args) {
		System.out.println(getColNumber("AC"));
	}
	
	public static int getColNumber(String src){
		int result = 0;
		int length = src.length();
		for(int i = 0; i < length ;i++){
			result = result*26 + src.charAt(i)- 'A'+1;
		}
		return result;
	}
}
