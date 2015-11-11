package com.thomas.test.leecode.easy;

import java.util.Arrays;


/**
 * 帕斯卡三角形
 * 在帕斯卡三角形中，每个数字都是上方与它相邻的两数之和。
 * return如下
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 *]
 * @author thomas
 * @time :2015年11月5日下午6:36:22
 */
public class N118PascalTriangle {
	
	public static void main(String[] args) {
		int[][] src = pascalT(10);
		int length = src.length;
		for(int i = 0;i< length;i++){
			System.out.println(Arrays.toString(src[i]));
		}
	}
	
	public static int[][] pascalT(int level) {
		int[][] result = new int[level][];
		result[0] = new int[] { 1 };
		for (int i = 1; i <= level-1; i++) {
			int[] levelAry = new int[i+1];
			for (int j = 0; j <= i; j++) {
				if (j - 1 < 0)
					levelAry[j] = result[i - 1][j];
				else if (j == i)
					levelAry[j] = result[i - 1][j - 1];
				else
					levelAry[j] = result[i - 1][j] + result[i - 1][j - 1];
			}
			result[i] = levelAry;
		}
		return result;
	}
}
