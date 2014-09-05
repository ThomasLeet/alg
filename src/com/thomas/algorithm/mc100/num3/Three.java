package com.thomas.algorithm.mc100.num3;

/**
 * 求子数组的最大和 题目: 输入一个整形数组,数组里有正数也有负数。 数组中连续的一个或多个整数组成一个子数组,每个子数组都有一个和。
 * 求所有子数组的和的最大值。要求时间复杂度为 O(n)。 例如输入的数组为 1, -2, 3, 10, -4, 7, 2, -5,和最大的子数组为 3,
 * 10, -4, 7, 2, 因此输出为该子数组的和 18。
 */

public class Three {

	public static void main(String[] args) {
		int[] src = new int[] { 100, 7, -3, 5 };// {100,-1000,101,-5};
		System.out.println(maxCount(src));
	}
	/**
	 * 自己写的
	 * 
	 * @param src
	 * @return
	 */
	public static int maxCount(int[] src) {
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < src.length; i++) {
			count += src[i];
			if (count < 0) {
				Math.max(max, src[i]);
				count = 0;
			} else {
				if (max < count)
					max = count;
			}
		}
		return max;
	}
}