package com.thomas.test.alm;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {
	
	public static void main(String[] args) {
		int[] src = new int[]{4,6,2,56,234,9,45,7,1};
		sort(src,0,src.length-1,3);
		System.out.println(Arrays.toString(src));
	}

	public static void sort(int[] src, int start, int end, int k) {
		// 在start和end区间取一个随机数
		if (start >= end)
			return;
		Random rand = new Random();
		int randIndex = (end - start) > 0 ? start + rand.nextInt(end - start)
				: start;
		int big = end;
		int small = start;
		while (big > small) {
			if (src[big] < src[randIndex])
				break;
			big--;
		}
		while (small < big) {
			if (src[small] > src[randIndex])
				break;
			small++;
		}
		if (small == big) {
			swap(src, randIndex, big);
		} else {
			swap(src, big, small);
		}
		//big是randIndex的值排序后对应的index
		if (big <= k) {
			sort(src, start, big - 1, k);
			sort(src, big + 1, end, k);
		} else {
			sort(src, start, big - 1, k);
		}
	}

	public static void swap(int[] src, int index1, int index2) {
		int tem = src[index1];
		src[index1] = src[index2];
		src[index2] = tem;
	}
}
