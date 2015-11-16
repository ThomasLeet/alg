package com.thomas.test.leecode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author thomas
 * @time :2015年11月13日上午11:52:05
 */
public class N228SummaryRanges {
	
	public static void main(String[] args) {
		List<String> list =  range(new int[]{0,1,2,5,7,8});
		for(String s : list){
			System.out.println(s);
		}
	}
	
	public static List<String> range(int[] sorted){
		List<String> range = new LinkedList<String>();
		if(null == sorted)
			return range;
		int length = sorted.length;
		Integer start = null;
		Integer end = null;
		for(int i = 0 ; i < length ; i++){
			if(null == start && null == end){
				start = end = sorted[i];
				continue;
			}
			if(sorted[i] != end +1){
				range.add(start != end ? start+"->"+end : start+"");
				start = end = sorted[i];
			}else{
				end = sorted[i];
			}
		}
		range.add(start != end ? start+"->"+end : start+"");
		return range;
	}
}
