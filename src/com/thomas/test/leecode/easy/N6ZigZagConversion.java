package com.thomas.test.leecode.easy;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * 说白了就是将字符按照Z字形排列，而且可以指定Z的列数
 * @author thomas
 * @time :2015年11月13日上午10:42:58
 */
public class N6ZigZagConversion {
	
	public static void main(String[] args) {
		System.out.println(toZ("PAYPALISHIRING",4));
	}

	public static String toZ(String src,int nRows){
		if(null == src)
			return "";
		char[] srcChars = src.toCharArray();
		StringBuilder[] sbr = new StringBuilder[nRows];
		for(int i = 0 ;i < nRows ; i++){
			sbr[i] = new StringBuilder();
		}
		int cursor = 0;
		int length = src.length();
		while(cursor < length){
			for(int i = 0;i < nRows && cursor < length; i++){
				sbr[i].append(srcChars[cursor++]);
			}
			for(int i = nRows - 2;i > 0 && cursor < length ;i--){
				sbr[i].append(srcChars[cursor++]);
			}
		}
		StringBuilder result = new StringBuilder();
		for(StringBuilder s : sbr){
			result.append(s);
		}
		return result.toString();
	}
}
