package com.thomas.algorithm.sort;

import java.util.Arrays;


/**
 * 选择排序，找出数组里面最小的数，和第一交换，然后在从剩余的数组里面找出最小的数和第二位交换
 * 注意：
 * 代码里面
 * @author thomas
 * @date 2013-10-18
 */
public class Selection {
	public static void sort(String[] input){
		if(null == input)
			return;
		for(int i=0;i<input.length;i++){
			int min=i;
			for(int j=i+1;j<input.length;j++){
				int com = input[j].compareTo(input[min]);//这里比较的是j和min对应的值，不是j和i。自己第一次写错了
				if(com<0)
					min=j;
			}
			String tem = input[min];
			input[min]=input[i];
			input[i]=tem;
			System.out.println(Arrays.toString(input));
		}
	}
	
	public static void rank(int[] src){
		if(src== null || src.length==0)
			return ;
		for(int i=0;i<src.length;i++){
			int max = i;
			for(int j =i;j<src.length;j++){
				if(src[j]>src[max])
					max = j;
			}
			swap(src,i,max);
		}
	}
	
	public static void swap(int[] src,int from,int to){
		int tem = src[to];
		src[to]=src[from];
		src[from]=tem;
	}
	
	public static void main(String[] args) {
		String[] input = new String[]{"1","5","7","9","2","4","8"};
		//sort(input);
		int[] inputNum = { 55, 324, 67, 3, 98, 2, 5, 48, 58, 1, 55 };
		rank(inputNum);
		for(int num : inputNum){
			System.out.print(num+",");
		}
		System.out.println("2".compareTo("4"));
		//System.out.println(Arrays.toString(input));
	}
}
