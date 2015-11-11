package com.thomas.test.leecode.easy;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * 判断数字是不是一个对称strobogrammatic数，
 *  the numbers "69", "88", and "818" are all strobogrammatic.
 *  时间 O(N) 空间 O(1)
 * @author thomas
 * @time :2015年11月4日下午2:23:50
 */
public class N246StrobogrammaticNumber {
	public static boolean isStrobogrammatic(int src){
		String  intSrc = src + "";
		int left = 0;
		int right = intSrc.length()-1;
		while(left != right){
			if(!checkChar(intSrc.charAt(left),intSrc.charAt(right)))
				return false;
		}
		return true;
	}
	
	public static boolean checkChar(char c1 , char c2){
		if(c1 == c2 && c1 == '1'  && c1 == '0' && c1 == '8'
				|| c1 == '6' && c2 == '9' || c1 == '9' && c2 =='6')
			return true;
		return false;
	}
}
