package com.thomas.test.alm;

import java.util.Arrays;

public class Main {
	
	public static int[] a = new int[]{3465,882,48,8,235,923,2345,70,1000,772345,77,22,168,3782,2792,3582}; 
	
	
	public static void main(String[] args) {
		//insert(a);
		//quick(a , 0,a.length-1);
		//System.out.println(Arrays.toString(a));
		//System.out.println(Arrays.toString(merge(a)));
		//System.out.println(7/2);
		//bubble(a);
		//System.out.println(Arrays.toString(a));
		heap(a);
		System.out.println(Arrays.toString(a));
		int length = a.length;
		for(int i=1;i<=length;i++){
			System.out.print(delHeap(a));
			System.out.print(",");
		}
	}
	
	/**
	 * 插入算法是保持0到i-1的数组是有序的，然后把i放在0到i-1的合适位置。
	 * 简单的方法是每次移动比i大的0到i-1中的值时，将i的数放在j中。
	 * 复杂的操作如下，只有最后一步才将i值放在合适的位置。但是注意两点
	 * 1.当j=0时如果移动了值就需要将i赋值到a[0]的位置。
	 * 2.当a[j]>a[i]的值时需要把a[i]的值放入a[j+1]中
	 * 延伸：链表的插入排序
	 * 
	 */
	public static void insert(int[] a){
		for(int i=1;i<a.length;i++){
			int key = a[i];
			for(int j = i-1 ; j >= 0 ; j--){
				if( key < a[j]){
					a[j+1] = a[j];//右移
					if(j == 0)
						a[j] = key;
				}else{
					a[j+1] = key;
					break;
				}
			}
		}
	}
	
	public static void quick(int[] src,int start,int end){
		int i = start;
		int j = end;
		int mid = src[i];
		while(i != j){
			while(src[j] >= mid && i < j){
				j--;
			}
			while(src[i] <= mid && i < j){
				i++;
			}
			if(src[j] < mid && src[i] > mid){
				int tem = src[j];
				src[j] = src[i];
				src[i] = tem;
			}
		}
		src[start] = src[i];
		src[i] = mid;
		System.out.println(Arrays.toString(a));
		if(i-1 > start){
			quick(src,start,i-1);
		}
		if(i+1 < end)
			quick(src,i+1,end) ;
	}
	
	
	/**
	 * 延伸：
	 * 链表的归并排序
	 */
	public static int[] merge(int a[]){
		if(a.length == 1)
			return a;
		int half = a.length / 2;
		int lefta[] =new int[half];
		int righta[] = new int[a.length - half];
		System.arraycopy(a, 0, lefta, 0, lefta.length);
		System.arraycopy(a, half, righta, 0, righta.length);
		int left[] = merge( lefta);
		int right[] = merge( righta);
		return combine(left,right);
	}
	
	public static int[] combine(int left[],int right[]){
		int tem[] = new int[left.length+right.length];
		int leftTotal = left.length;
		int rightTotal = right.length;
		int i=0,j=0,temIndex=0;
		while(temIndex < tem.length){
			if(j < rightTotal && (i >= leftTotal || left[i] > right[j])){
				tem[temIndex++]=right[j++];
			}
			if(i < leftTotal && (j >= rightTotal || left[i] < right[j])){
				tem[temIndex++]=left[i++];
			}
		}
		return tem;
	}
	
	
	public static void select(int[] src){
		int length = src.length;
		for(int i=0;i < length;i++){
			int minIndex = i;
			for(int j=i;j<length;j++){
				if(src[minIndex] > src[j])
					minIndex = j;
			}
			int tem = src[i];
			src[i] = src[minIndex];
			src[minIndex] = tem;
		}
	}
	
	public static void bubble(int[] src){
		int length = src.length;
		for(int i = 0;i < length;i++){
			for(int j = length-1;j>i;j--){
				if(src[j-1] > src[j]){
					int tem = src[j];
					src[j] = src[j-1];
					src[j-1] = tem;
				}
			}
		}
	}
	
	
	public static void heap(int[] a){
		buildHeap(a);
	}
	
	public static void buildHeap(int[] a){
		int index = parent(a.length -1);
		for(int i = index ;i >=0 ;i--){
			maxHeapify(a, i);
		}
		
	}
	
	public static void maxHeapify(int[] a,int nodeIndex){
		int leftIndex = left(nodeIndex);
		int rightIndex = right(nodeIndex);
		int maxChildIndex = 0;
		if(leftIndex >= a.length)
			maxChildIndex = rightIndex;
		else if(rightIndex >= a.length)
			maxChildIndex = leftIndex;
		else
			maxChildIndex = a[leftIndex] > a[rightIndex] ? leftIndex : rightIndex;
		
		if(maxChildIndex < a.length && a[maxChildIndex] > a[nodeIndex]){
			swap(a,maxChildIndex,nodeIndex);
			maxHeapify(a,maxChildIndex);
		}
	}
	
	public static void maxHeapify1(int[] a,int nodeIndex){
		int leftIndex = left(nodeIndex);
		int rightIndex = right(nodeIndex);
//		if(leftIndex >= a.length || rightIndex >= a.length)
//			return;
		if(leftIndex < a.length && a[leftIndex] > a[nodeIndex]){
			swap(a,leftIndex,nodeIndex);
			maxHeapify(a,leftIndex);
		}
		if(rightIndex < a.length && a[rightIndex] > a[nodeIndex]){
			swap(a,rightIndex,nodeIndex);
			maxHeapify(a,rightIndex);
		}
	}
	
	public void insertHeap(int value,int[] src){
		
	}
	
	public static int delHeap(int[] src){
		int top = src[0];
		src[0] = src[src.length - 1];
		int[] newArray = new int[src.length-1];
		System.arraycopy(src, 0, newArray, 0, newArray.length);
		a = newArray;
		maxHeapify(a, 0);
		return top;
	}
	
	public static void swap(int[] a,int index1,int index2 ){
		int tem = a[index1];
		a[index1] = a[index2];
		a[index2] = tem;
	}
	
	public static int left(int index){
		return (index << 1) + 1;
	}
	
	public static int right(int index){
		return (index << 1) + 2;
	}
	
	public static int parent(int index){
//		if(index == 0)
//			return 0;
		return (index-1) >> 1;
	}
	
	
	
	
	
}
