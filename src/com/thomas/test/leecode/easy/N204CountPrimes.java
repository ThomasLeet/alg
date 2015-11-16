package com.thomas.test.leecode.easy;

/**
 * 计算小于一个非负数字素数的数量,n。
 * @author thomas
 * @time :2015年11月13日上午11:00:28
 */
public class N204CountPrimes {
	
	public static void main(String[] args) {
		System.out.println(Math.sqrt(4));
	}
	//不是自己写的，
	public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}
