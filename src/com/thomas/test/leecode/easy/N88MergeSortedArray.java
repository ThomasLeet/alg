package com.thomas.test.leecode.easy;

import java.util.Arrays;

/**
 * 给定两个已排序的整数数组nums1 nums2,nums2合并到nums1作为一个有序数组。
 * nums1有足够的空间放置num1+num2
 * m是num1的长度，n是num2的长度
 * 
 * @author thomas
 * @time :2015年11月6日下午6:54:10
 */
public class N88MergeSortedArray {
	
	public static void main(String[] args) {
		int[] src = new int[]{1,3,4,6,0,0,0,0,0,0};
		mergeArray(src,4,new int[]{5,7,8,9},4);
		System.out.println(Arrays.toString(src));
	}
	
	public static void mergeArray(int[] a1,int m , int[] a2,int n){
		int l1 = m-1;
		int l2 = n-1;
		int c = m+n-1;
		while(l1 >=0 && l2 >= 0){
			if(a1[l1] >= a2[l2]){
				a1[c--] = a1[l1--];
			}else{
				a1[c--] = a2[l2--];
			}
		}
		if(l2 >= 0){
			a1[c--] = a2[l2--];
		}
	}
}
