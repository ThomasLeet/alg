package com.thomas.test.auly;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

public class One {
	//1
	//2详见MinStack min方法
	
	public static void main(String[] args) {
		//three();
		four();
	}
	//3
	public static void three() {
		int[] src = new int[]{3,6,4,-4,-3,5,6,-18,2,58,-5};
		System.out.println(maxSum(src));
	}
	
	public static int maxSum(int[] src){
		int maxSum = Integer.MIN_VALUE;
		int length = src.length;
		int tem = 0;
		for(int i = 0;i< length;i++){
			if(tem+src[i] > 0){
				tem += src[i];
				if(tem > maxSum)
					maxSum = tem;
			}else{
				tem = 0;
			}
		}
		return maxSum;
	}
	
	//4
	public static void four(){
		BinaryTree tree = new BinaryTree();
		int[] input = new int[]{5,4,6,8,2,3,1,7,9};
		for(int i =0 ;i< input.length;i++){
			tree.add(input[i]);
		}
		int[] path = new int[input.length];
		int top = 0;
		backTrack(tree.root,11,path,top);
	}
	
	//当和等于total，打印路径
	//当路径和不等以total，向下一级求和
	//当结点为空返回，当左右都遍历完回溯
	//回溯就是删除数组的最大值。
	//前序遍历
	public static void backTrack(Node start,int sum,int[] path,int top){
		if(null == start)
			return ;
		path[top++] = start.value;
		if(sum - start.value == 0){
			printArray(path,top);
		}
		backTrack(start.left,sum-start.value,path,top);
		backTrack(start.right,sum-start.value,path,top);
		path[--top] = 0;
	}
	
	public static void printArray(int[] src,int top){
		for(int i=0 ;i<top;i++){
			System.out.print(src[i]+",");
		}
		System.out.println("");
	} 
	
	/**
	 * 5重点！两种方法
	 * 1.快速选择排序 见QuickSelect
	 	快选，每次选一部分，扔掉另一部分，所以是O(N)
		假设每次扔掉一半.
		（2^k=N)
		T(N) =n +n/2+n/4+n/8+n/2^k = n*(1-2^-k)/(1-2^-1) =2N 
		这是粗略估计，具体看算法导论。
		不过最坏时间复杂度（例如所有元素相等）大概=O（NlogN)
	 * 2.最大堆（因为取k个最小的数，需要和已有的k个数的最大那个进行比较）
	 */
	
	/**
	 * 6 字符串操作的代表 http://haolloyin.blog.51cto.com/1177454/560597/
	 * http://www.cnblogs.com/kirinboy/archive/2010/04/23/reverse-a-string.html
	 * 1.把字符串向左，或者向右移动k次。如123456789->456789123
	 * 2.或者把一句话的按照词翻转。如 我爱天安门->天安门爱我
	 *在两个字符交换的时候，可以不用临时变量。
	 *将两个数异或后，在异或回来就换换了，如下
	 *010 110
	 *100 110
	 *100 010
	 *110 010
	 *100 001 原理是两个数，求出异或后的值后，用这个值与自己异或就得到对方值，用这个值异或对方值就得到了自己的值。
	 */
	
	/**
	 * 遇到的异或题目
	 * 数字中两两相同，只有一个不同
	 */
	public void yuhuo(){
		int[] src = new int[] { 4, 6, 6, 7, 4, 5, 7, 6, 5, 6, 9 };
		int sum = 0;
		for (int i = 0; i < src.length; i++) {
			sum^=src[i];
		}
		System.out.println(sum);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
