package com.thomas.test.leecode.easy;

/**
 * 我们把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。
 * @author thomas
 * @time :2015年11月3日上午11:48:27
 */
public class N263UglyNumber {
	
	public static void main(String[] args) {
		System.out.println(ugly(162));
	}
	
	public static boolean ugly(int src){
		if(src == 1)
			return true;
		while(src % 2 == 0)
			src = src >>>1;
		while(src % 3 == 0)
			src = src/3;
		while(src % 5 == 0)
			src = src/5;
		return src != 1; 
	}
}
