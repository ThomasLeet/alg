package com.thomas.test.leecode.easy;

/**
 * 题目很简单明了，就是给定N，求N！(阶乘)的末尾有多少0。要求算法复杂度为lg。　　 　
 * 注意:您的解决方案应该在对数时间复杂度。
 * 
 * 比较绕：
 * 思路如下
 * 首先分析N！末尾的0，只有2*5的情况下才会出现。所以对N!进行素数分解：N！=2^i****5^j***.
 * 则末尾0的个数为min(i,j). 又由于i明显远大于j，所以我们只要求解j即可。
 * 又j均由1-N中5的倍数所提供，如果该数仅为5的倍数则贡献1，若为25的倍数则贡献2.
 * 而1-N中，5的倍数个数为|_N/5_|，|_ _|表示取下整数。
 * 又1-N中，25的倍数个数为|_N/25_|.需要注意到的是|_N/5_|已经包含了|_N/25_|。
 * 又25的倍数贡献了2，所以考虑到避免重复计算，则N!的素数分解中5的指数j为：
 * j = |_N/5_|+|_N/25_|+|_N/5^3_|+...
 * @author thomas
 * @time :2015年11月6日下午2:09:05
 */
public class N172FactorialTrailingZeroes {
	public static void main(String[] args) {
		System.out.println(zeroesNumber(10));
	}
	
	public static int zeroesNumber(int src){
		int count = 0;
		int tem = 0;
		while((tem = src/5) > 0){
			count += tem;
			src /= 5;
		}
		return count;
	}
}
