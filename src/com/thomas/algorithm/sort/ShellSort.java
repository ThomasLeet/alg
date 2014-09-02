package com.thomas.algorithm.sort;


/**
 * 希尔排序:
 * 是对数组一定步长中元素的快速排序算法，解决随机数中的数远离它排序后应在的位置的情况。
 * 跨步是3n+1
 * 回退是n/3
 * 最后的步长一定是1才行
 * @author thomas
 * @date 2013-10-19
 */
public class ShellSort {
	public static void sort(int[] input){
		if(null == input||input.length==0)
			return ;
		int size = input.length;
		int step = 1;
		while(step<size/3)
			step = 3*step+1;
		while(step>=1){
			for(int i =step;i<size;i++){
				for(int j=i;j>=step;j-=step){
					if(input[j]>input[j-step]){
						break;
					}
					swap(input,j,j-step);
				}
			}
			step=step/3;
		}
	}
	
	public static void swap(int[] input,int from,int to){
		int tem = input[from];
		input[from]=input[to];
		input[to]=tem;
	}
	
	public static void main(String[] args) {
		int[] a = {55,324,67,3,98,2,5,48,58,1,55,6,4,77,234,56};
		sort(a);
		for(int i : a){
			System.out.print(i+",");
		}
		System.out.println(Integer.MAX_VALUE);
	}
}
