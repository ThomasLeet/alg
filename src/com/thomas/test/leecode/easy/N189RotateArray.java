package com.thomas.test.leecode.easy;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7]
 *  is rotated to [5,6,7,1,2,3,4].
 * @author thomas
 * @time :2015年11月16日上午10:13:55
 */
public class N189RotateArray {
	
	public static void main(String[] args) {
		int[] src = new int[]{1,2,3,4,5,6,7};
		rotate(src,3);
		System.out.println(Arrays.toString(src));
	}
	
	
	public static void rotate(int[] nums, int k) {
		reverse(nums,0,nums.length-k-1);
		reverse(nums,nums.length-k,nums.length-1);
		reverse(nums,0,nums.length-1);
    }
	
	public static void reverse(int[] nums , int start ,int end){
		if(null == nums || start < 0 || end >= nums.length || start >= end)
			return;
		while(start < end){
			swap(nums,start++,end--);
		}
	}
	
	public static void swap(int[] nums ,int ia , int ib){
		int tem = nums[ia] ^ nums[ib];
		nums[ia] = nums[ia] ^ tem;
		nums[ib] = nums[ib] ^ tem;
	}
}
