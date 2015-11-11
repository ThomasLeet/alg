package com.thomas.test.leecode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个整数数组,
 * 发现如果数组包含任何副本。
 * 你的函数应该返回true,如果任何值数组中出现至少两次,
 * 它应该返回false如果每个元素是截然不同的。
 * @author thomas
 * @time :2015年10月29日下午4:48:57
 */
public class N217ContainsDuplicate {
	
	public static void main(String[] args) {
		int[] src = new int[]{6,7,5,8,9,2,4,3,2};
		System.out.println(hasDuplicate(src)+" , "+ hasDuplicate2(src));
	}
	
	//Time complexity: O(N lg N), memory: O(1) - not counting the memory used by sort
	public static boolean hasDuplicate(int[] src){
		Arrays.sort(src);
		int length = src.length;
		for(int i = 0 ;i < length-1;i++){
			if(src[i] == src[i+1])
				return true;
		}
		return false;
	}
	
	public static boolean hasDuplicate2(int[] src){
		HashSet<Integer> set = new HashSet<Integer>();
		int length = src.length;
		for(int i = 0 ;i < length-1;i++){
			if(set.contains(src[i])){
				return true;
			}else{
				set.add(src[i]);
			}
		}
		return false;
	}
}
