package com.thomas.algorithm.sort;

import java.util.LinkedList;

/**
 * 插入排序——将下一个插入已排好的序列中 
 * 
 * 插入排序算法类似于玩扑克时抓牌的过程，玩家每拿到一张牌都要插入到手中已有的牌里，使之从小到大排好序。
 * @author thomas
 * @date 2013-5-20
 */
public class InsertSort {
	
	/**
	 * 插入排序就是保证元素i左边的元素都是有序的
	 * 注意：
	 * j和i从相同的地方开始，内循环的时候不用i而是用j和j-1因为要循环向前递增。
	 * 自己的错误：
	 * 没有定好i和j的开始部分，还烦了错误input[j]>=input[i]进行比较了。
	 * @return
	 */
	public static int[] sort(int[] input){
		for(int i=1;i<input.length;i++){
			for(int j=i;j>=1;j--){
				if(input[j]>=input[j-1]){//input[j]>=input[i]是错误的
					break;
				}
				swap(input,j-1,j);
				//TODO 把大于j的元素都向右移动，这样访问数组的次数减半
			}
		}
		return input;
	}
	
	public static void rankTest(int[] a){
		if(a==null||a.length==0)
			return;
		for(int i=1;i<a.length;i++){
			for(int j=i;j>0;j--){
				if(a[j]>a[j-1])
					break;
				swap(a,j,j-1);
			}
		}
	}
	
	public static void swap(int[] input,int from,int to){
		int tem = input[from];
		input[from]=input[to];
		input[to]=tem;
	}
	
	//从小到大排列
	public static void run(int[] array){
		//建立一个数组来存放排序好的数组
		LinkedList<Integer> result =new LinkedList<Integer>();
		result.add(array[0]);
		for(int i = 1;i<array.length;i++){
			for(int li=0;li<result.size();li++){
				if(array[i]<=result.get(li))
					if(li==0){
						result.addFirst(array[i]);
					}else{
						result.add(li-1, array[i]);
					}
			}
		}
		print(result);
	}
	
	public static void main(String[] args){
		int[] a = {55,324,67,3,98,3,5,48,58,3,55,6,4,77};
		//run(a);
		sort(a);
		for(int i =0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
	}
	
	public static void print(LinkedList<Integer> list){
		for(int a : list){
			System.out.print(a+",");
		}
		System.out.println("");
	}
}
