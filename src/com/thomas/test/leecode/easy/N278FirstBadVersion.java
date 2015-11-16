package com.thomas.test.leecode.easy;

/**
 * 你是一个产品经理,目前领导一个团队开发一个新产品。 
 * 不幸的是,你的产品的最新版本不能检查质量。
 * 因为每个版本开发基于之前的版本。
 * 假设你有n版本[1、2、……n]和你想找出第一个坏,导致所有以下的是坏的。 
 * 你给出一个API bool isBadVersion(版本)将返回是否版本是不好的。 
 * 实现一个函数来找到第一个糟糕的版本。你应该减少调用API的数量。
 * 
 * @author thomas
 * @time :2015年11月13日下午4:35:21
 */
public class N278FirstBadVersion {
	
	public static void main(String[] args) {
		int[] src = new int[]{1,3,5,6,8,6,8,4,5};
		//System.out.println(firstBadVersion(src, 0, src.length-1));
		System.out.println(firstBadVersion1(10));
	}
	
	//错了！！！！！
	public static int firstBadVersion(int[] versions,int start,int end) {
		if(null == versions)
			return -1;
		if(start == end){
			if(isBadVersion(versions[start]))
				return versions[start];
			else
				return -1;
		}
		int middle = (end-start) / 2 + start;
		int leftVersion = firstBadVersion(versions,start,middle);
		if(leftVersion > 0)
			return leftVersion;
		int rightVersion = firstBadVersion(versions,middle+1,end);
		return rightVersion;
	}
	
	/**
	 * 条件非常精确！！！
	 * @param n
	 * @return
	 */
	public static int firstBadVersion1(int n) {
		int start = 1;
		int end = n;
		while(start < end){
			int mid = (end-start)/2+start;
			if(isBadVersion(mid)){
				end = mid;
			}else{
				start = mid+1;
			}
		}
		return start;
	}
	
	public static boolean isBadVersion(int v){
		if(v == 5)
			return true;
		return false;
	}
}
