package com.thomas.test.leecode.easy;

import java.util.Arrays;

/**
 * 一个num数组,编写一个函数来将所有0移动到它结尾处,同时保持非零元素的相对顺序。
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 注意：
 * 1.不能复制数组
 * 2.减少操作的总数。
 * 
 * @author thomas
 * @time :2015年10月29日下午3:28:43
 */
public class N283MoveZeroes {
	
	public static void main(String[] args) {
		int[] src = new int[]{5,6,7,0,8,9,0,0,10,11,13,0,0,15,16,0};
		moveZero(src);
		System.out.println(Arrays.toString(src));
	}
	
	/**
	 * 思路：
	 * 1.记录每个数组相应位置（i）前有多少个0（n），直接把这个位置的值赋值到（i+n）。
	 * 2.记录数组有多少个非零的数，因为这样数已经移动到相应的位置了，把后面的非零清零
	 * @param src
	 */
	public static void moveZero(int[] src){
		int nonZeroNumber = 0;
		int relative = 0;
		int length = src.length;
		for(int i = 0 ; i < length ; i++){
			if(src[i] == 0){
				relative++;
			}else{
				nonZeroNumber++;
				if(relative > 0){
					src[i-relative] = src[i];
				}
			}
		}
		for(int i = nonZeroNumber; i<length ;i++){
			if(src[i] != 0)
				src[i] =0;
		}
	}
}
