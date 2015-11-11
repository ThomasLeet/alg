package com.thomas.algorithm.sort;

public class Merge {

	private static int[] aux;

	/**
	 * 递归前准备工作要单独放出来，不放在递归的方法里
	 * 
	 * @param input
	 */
	public static void sort(int[] input) {
		if (input == null || input.length == 0)
			return;
		aux = new int[input.length];
		sort(input, 0, input.length - 1);
	}

	/**
	 * 递归方法（自上而下）
	 * 
	 * @param input
	 */
	public static void sort(int[] input, int lo, int hi) {
		if (lo == hi)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(input, lo, mid);
		sort(input, mid + 1, hi);
		merge(input, lo, mid, hi);
	}
	
	/**
	 * 非递归方法(自下而上)
	 */
	public static void smallToBigSort(int[] input) {
		if (input == null || input.length == 0)
			return;
		aux = new int[input.length];
//		int step=2;
//		int length = input.length;
//		while(step<=length){
//			//被step划分了多少块。
//			int k = (length%step)==0?length/step:length/step+1;
//			for(int i=0;i<=k;i++){
//				int lo = step*i;
//				int hi = (step*i+step-1)<length-1?step*i+step-1:length-1;
//				int mid = lo+(hi-lo)/2;
//				merge(input,lo,mid,hi);
//			}
//			step = step+step;
//		}
		int length = input.length;
		for(int step=1 ;step<=length;step=step+step){//步长成倍增大
			for(int i=0;i<length-step;i+=step*2){//递归排序每块//不按照第几个step块计算，按照每块的第一个元素的索引算
				merge(input,i,i+step-1,Math.min(i+step+step-1, length-1));
			}
		}
	}

	private static void merge(int[] input, int lo, int mid, int hi) {
		int plo = lo;
		int phi = mid + 1;
		// 一次性初始化辅助数组,初始化部分每次merge都要做，
		//来保持aux能拿到之前排好序的数组部分
		for (int i = lo; i <=hi; i++) {
			aux[i] = input[i];
		}
		System.out.println("lo:"+lo+",hi:"+hi);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ",");
		}
		for (int index = lo; index <= hi; index++) {
			if (plo > mid) {
				input[index] = aux[phi++];
			} else if (phi > hi) {
				input[index] = aux[plo++];
			} else if (aux[plo] > aux[phi]) {
				input[index] = aux[phi++];
			} else {
				input[index] = aux[plo++];
			}
		}
	}

	public static void main(String[] args) {
		int[] input = { 55, 324, 67, 3, 98, 2, 5, 48, 58, 1, 55 };
		//sort(input);
		smallToBigSort(input);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ",");
		}
	}
}
