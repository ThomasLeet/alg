package com.thomas.test.leecode.easy;

import java.util.Arrays;

/**
 * 给定一个已排序的数组,删除重复的地方,这样每个元素只出现一次,并返回新的长度。 　　 　　
 * 不分配额外的空间为另一个数组,memery O(1)
 * [1,1,2]
 * [1,2]
 * 原来的数组在1，2以后的不管。
 */
public class N26RemoveDuplicatesfromSortedArray {
	
	public static void main(String[] args) {
		int[] src = new int[]{1,1,2,3,3,3,5,6,10};
		System.out.println(removeDuplicate(src));
		System.out.println(Arrays.toString(src));
	}

	/**
	 * target这个变量可以省略
	 * https://leetcode.com/discuss/10314/my-solution-time-o-n-space-o-1
	 * @param src
	 * @return
	 */
	public static int removeDuplicate(int[] src){
		if(null == src)
			return 0;
		Integer target = null;
		int relativeIndex = 0;
		int srcLength = src.length;
		for(int i = 0 ; i < srcLength ; i++){
			if(null == target || target != src[i]){
				src[relativeIndex++] = src[i];
				target = src[i];
			}
		}
		return relativeIndex;
	}
}
