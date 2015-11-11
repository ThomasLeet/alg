package com.thomas.test.leecode.easy;

/**
 * 你是爬楼梯。需要n步达到顶部。 　　 
 * 每一次你可以爬1或2的步骤。有多少不同的方式爬上去?
 * @author thomas
 * @time :2015年11月2日下午5:13:03
 */
public class N70ClimbingStairs {

	public static void main(String[] args) {
		int src = 4;
		System.out.println(waysNumber(src,1,"")+waysNumber(src,2,""));
	}
	
	/**
	 * 斐波那契
	 * 基本情况: 　　如果n < = 0,那么多种方式应该是零。
	 * 如果n = = 1,那么只有爬上楼梯。
	 * 如果n = = 2,那么有两种方法可以爬楼梯。
	 * 
	 * n级台阶的组合= (n-1)阶 + (n-2)阶 
	 * 因为(n-1)阶需要迈一个台阶，(n-2)阶需要买两节台阶，而且互相没有冲突（因为最后一步不同）
	 * 规律：
	 * 1.此部分可以通过前两个部分推到而来
	 * 2.且连两个部分不重复，不冲突
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
	    // base cases
	    if(n <= 0) return 0;
	    if(n == 1) return 1;
	    if(n == 2) return 2;

	    int one_step_before = 2;
	    int two_steps_before = 1;
	    int all_ways = 0;

	    for(int i=2; i<n; i++){
	        all_ways = one_step_before + two_steps_before;
	        one_step_before = two_steps_before;
	        two_steps_before = all_ways;
	    }
	    return all_ways;
	}   
	
	/**
	 * 自己的解法
	 * @param rest
	 * @param stop
	 * @param print
	 * @return
	 */
	public static int waysNumber(int rest,int stop,String print){
		int current = rest - stop;
		if(current < 0)
			return 0;
		if(current == 0){
			System.out.println(print+" , "+stop );
			return 1;
		}
		print = print+" , "+stop;
		int oneTotal = waysNumber(current,1,print);
		int twoTotal = waysNumber(current,2,print);
		return  oneTotal+twoTotal;
	}
}
