package com.thomas.test.leecode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组nums与一个整数k，
 * 如果数字中有重复的数，而且他们的index差不超过k则返回true；
 * 否则返回false。
 * @author thomas
 * @time :2015年11月10日下午3:47:10
 */
public class N219ContainsDuplicateII {
	
	public static void main(String[] args) {
		System.out.println(!hasDuplicate(new int[]{1,2,3,4,2,6,7}, 3));
	}
	
	public static boolean hasDuplicate(int[] src,int dist){
		Set<Integer> withInk = new HashSet<Integer>();
		for(int i = 0 ;i <src.length ;i++){
			if(i > dist)
				withInk.remove(src[i-dist-1]);
			if(!withInk.add(src[i])){
				return false;
			}
		}
		return true;
	}
}
