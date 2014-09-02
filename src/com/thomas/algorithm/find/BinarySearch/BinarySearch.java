package com.thomas.algorithm.find.BinarySearch;

/**
 * 二分查找
 * 要求是有序的数组，且不经常变化，读的次数多。因为数组插入性能查。
 * 查找快 最多logN次
 * 
 * @author thomas
 * @date 2013-10-18
 */
public class BinarySearch {
	
	/**
	 * 非递归算法
	 * 注意：
	 * 1.给tail 和 head赋值时注意不要把middle直接赋值给他们，因为middle已经比较过了。而且如果直接把middle赋值给他们会出现死循环，
	 * 因为当循环当head tail紧邻的时候，不管要比较的值大于还是小宇middle时head和tail都不会变了。
	 * 2.不用单独处理head==tail的情况，因为middle的比较中已经比较了
	 * @param input
	 * @param searchStr
	 * @return
	 */
	public static int rank(int[] input,int searchStr){
		if(input == null||input.length==0)
			return -1;
		int head = 0;
		int tail = input.length-1;
		while(head<=tail){
//			if(head==tail&&input[head]==searchStr){
//				return head;
//			}
			int middle = head+(tail-head)/2;
			if(input[middle]==searchStr)
				return middle;
			if(input[middle]>searchStr)
				tail=middle-1;
			if(input[middle]<searchStr)
				head=middle+1;
		}
		return -1;
	}
	
	public static int  binaryTest(int[] src,int input){
		if(src == null || src.length==0)
			return -1;
		int lo = 0;
		int hi = src.length-1;
		while(lo<=hi){
			int mid = lo+(hi-lo)/2;
			if(input==src[mid])
				return mid;
			if(input<src[mid])
				hi=mid-1;
			if(input>src[mid])
				lo=mid+1;
		}
		return -1;
	}
	
	/**
	 * 递归的算法，使用object 的 compare进行比较
	 * 注意：
	 * 最后两个指针边界的处理，就是if(lo>hi)的判断
	 * 优化就是input[middle].compareTo(researchStr)结果放在一个变量里，不要在判断语句里面每次调用
	 * @param input
	 * @param searchStr
	 * @return
	 */
	public static int recursionRank(String researchStr,int lo,int hi,String[] input){
		if(lo>hi)
			return -1;
		int middle = lo+(hi-lo)/2;
		int comp = input[middle].compareTo(researchStr);
		if(comp==0)
			return middle;
		if(comp<0)
			recursionRank(researchStr,middle+1,hi,input);
		if(comp>0)
			recursionRank(researchStr,lo,middle-1,input);
		return -1;
	}
	
	public static int binaryTest2(int[] src,int lo,int hi,int input){
		if(src==null||src.length==0)
			return -1;
		int mid=lo+(hi-lo)/2;
		if(input==src[mid])
			return mid;
		if(lo==hi)
			return -1;
		if(input<src[mid]){
			return binaryTest2(src,lo,mid-1,input);
		}else{
			return binaryTest2(src,mid+1,hi,input);
		}
	}
	
	public static void main(String[] args) {
		
		//int[] input = new int[]{1,2,3,5,6,16,18,28,56,88,99};
		//System.out.println(rank(input,89));
		
		String[] inputStr = new String[]{"1","2","3","5","6","16","18","28","56","88","99"};
		System.out.println(recursionRank("88",0,inputStr.length-1,inputStr));
		int[] a = {1,2,3,5,7,11,13,15,16,17,18,26,36,37,55,66};
		//System.out.println(binaryTest(a,17));
		System.out.println(binaryTest2(a,0,a.length-1,18));
	}
}
