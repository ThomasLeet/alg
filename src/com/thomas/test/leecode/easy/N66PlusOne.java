package com.thomas.test.leecode.easy;

import java.util.Arrays;

/**
 * 用数组表示一个int正数，给这个数加一
 * [1,2,3,9]+1
 * 等于
 * [1,2,4,0]
 * @author thomas
 * @time :2015年11月5日下午5:40:07
 */
public class N66PlusOne {
	
	public static void main(String[] args) {
		int[] src = new int[]{1,9,9,9};
		plusOne(src);
		System.out.println(Arrays.toString(src));
	}
	
	public static void plusOne(int[] src){
		for(int i = src.length -1 ; i >= 0 ;i--){
			if(src[i] < 9){
				src[i] = src[i]+1;
				break;
			}
			src[i] = 0;
		}
	}	
}
