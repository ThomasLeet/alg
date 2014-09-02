package com.thomas.algorithm.sort;

/**
 * 冒泡（Bubble）排序——相邻交换
 * 
 * 最简单的排序方法是冒泡排序方法。这种方法的基本思想是，将待排序的元素看作是竖着排列的“气泡”，较小的元素比较轻，从而要往上浮。
 * 在冒泡排序算法中我们要对这个“气泡”序列处理若干遍。所谓一遍处理，就是自底向上检查一遍这个序列，并时刻注意两个相邻的元素的顺序是否正确。
 * 如果发现两个相邻元素的顺序不对，即“轻”的元素在下面，就交换它们的位置。显然，处理一遍之后，“最轻”的元素就浮到了最高位置；处理二遍之后，“次轻”的元素就浮到了次高位置。
 * 在作第二遍处理时，由于最高位置上的元素已是“最轻”元素，所以不必检查。
 * 一般地，第i遍处理时，不必检查第i高位置以上的元素，因为经过前面i-1遍的处理，它们已正确地排好序。
 * 
 * @author thomas
 * @date 2013-5-20
 */
public class Bubble {
	public void run(){
		
	}
	
	public static void rank(int[] src){
		if(src==null || src.length==0)
			return;
		int j=src.length-1;
		while(j>0){
			for(int i =0;i<j;i++){
				if(src[i]<src[i+1])
					swap(src,i,i+1);
			}
			j--;
		}
	}
	
	public static void rank2(int[] src){
		if(src == null || src.length==0)
			return;
		for(int j=src.length-1;j>0;j--){
			for(int i=0;i<j;i++){
				if(src[i]<src[i+1])
					swap(src,i,i+1);
			}
		}
	}
	
	public static void swap(int[] src,int from,int to){
		int tem = src[to];
		src[to]=src[from];
		src[from]=tem;
	}
	
	public static void main(String[] args) {
		int[] a = {55,324,67,3,98,2,5,48,58,1,55,6,4,77,234,56};
		rank2(a);
		for(int input : a){
			System.out.print(input+",");
		}
	}
}
