package com.thomas.algorithm.sort;

/**
 * 直接选择排序(Straight Select Sorting)--每次最小/大排在相应的位置 
 * 复杂度是 O(n*n)
 * 选择排序的基本思想是：
 * 对待排序的记录序列进行n-1遍的处理，第1遍处理是将L[1..n]中最小者与L[1]交换位置，
 * 第2遍处理是将L[2..n]中最小者与L[2]交换位置，......，第i遍处理是将L[i..n]中最小者与L[i]交换位置。
 * 这样，经过i遍处理之后，前i个记录的位置就已经按从小到大的顺序排列好了。
　　当然，实际操作时，也可以根据需要，通过从待排序的记录中选择最大者与其首记录交换位置，按从大到小的顺序进行排序处理。
 * @author thomas
 * @date 2013-5-20
 */
public class StraightSelectSorting {
	public static void run(int[] array){
		int max = array.length;
		for(int index=0 ;index<max;index++){
			int minIndex=index;
			int min = array[index];
			for(int index2=index;index2<max;index2++){
				//找到最小的那个,然后记录下标和值
				if(array[index2]<min){
					minIndex=index2;
					min = array[index2];
				}
			}
			//将最小和第index个进行调换
			if(minIndex!=index){
				array[minIndex]=array[index];
				array[index]=min;
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {5,4,89,4,7,4,2};
		print(array);
		run(array);
		print(array);
	}
	
	public static void print(int[] array){
		for(int a : array){
			System.out.print(a+",");
		}
		System.out.println("");
	}
}
