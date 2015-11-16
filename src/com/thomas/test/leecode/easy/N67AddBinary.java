package com.thomas.test.leecode.easy;


/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * @author thomas
 * @time :2015年11月11日下午4:50:15
 */
public class N67AddBinary {
	public static void main(String[] args) {
		//System.out.println(addBinaryNice("111","111"));
		System.out.println((char)65);
	}
	
	//自己
	public static String addBinary(String src1,String src2){
		if(null == src1 || null == src2)
			return null == src2 ? src1 : src2;
		int length1 = src1.length();
		int length2 = src2.length();
		int maxLength = Math.max(length1,length2);
		char[] result = new char[maxLength];
		boolean addOne = false;
		for(int i = 0 ;i < maxLength ;i++){
			char c1 = length1 -1 - i >= 0 ? src1.charAt(length1 -1-i) : '0';
			char c2 = length2 -1 - i >= 0 ? src2.charAt(length2 -1-i) : '0';
			if(c1 == c2){
				if( c1 == '1'){
					if(addOne)
						result[maxLength-1 - i]='1';
					else 
						result[maxLength-1 - i]='0';
					addOne = true;
				}else{
					addOne = false;
					if(addOne){
						result[maxLength-1 - i]='1';
					}else{
						result[maxLength-1 - i]='0';
					}
				}
			}else{
				if(addOne){
					addOne = true;
					result[maxLength-1 - i]='0';
				}else{
					result[maxLength-1 - i]='1';
				}
			}
		}
		return  addOne ? "1"+new String(result) : new String(result);
	}
	
	public static String addBinaryNice(String src1,String src2){
		if(null == src1 || null == src2)
			return null == src2 ? src1 : src2;
		int length1 = src1.length();
		int length2 = src2.length();
		int maxLength = Math.max(length1,length2);
		char[] result = new char[maxLength];
		int addOne = 0;
		for(int i = 0 ;i < maxLength ;i++){
			char c1 = length1 -1 - i >= 0 ? src1.charAt(length1 -1-i) : '0';
			char c2 = length2 -1 - i >= 0 ? src2.charAt(length2 -1-i) : '0';
			int i1 = Character.getNumericValue(c1);
			int i2 = Character.getNumericValue(c2);
			int digit = i1 ^ i2 ^ addOne;
			addOne = i1 + i2 + addOne >= 2 ? 1 : 0;
			result[maxLength - 1 - i] = (char)('0'+digit);
		}
		return  addOne == 1 ? "1"+new String(result) : new String(result);
	}
}
