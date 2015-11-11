package com.thomas.test.leecode.easy;

/**
 * 有一个栅栏它有n个木桩，每个木桩有k个颜色粉刷，而且每个相邻的木桩不能用相同的颜色。
 * 问粉霜整个栅栏有多少种颜色组合。
 * @author thomas
 * @time :2015年11月10日下午6:06:21
 */
public class N276PaintFence {
	
	public static void main(String[] args) {
		System.out.println(printWays(4,12));
	}
	
	public static int printWays(int fences, int color) {
		int ways = 0;
		for (int i = 1; i <= fences; i++) {
			if(i == 1)
				ways = color;
			else
				ways *= color -1;
		}
		return ways;
	}
}
