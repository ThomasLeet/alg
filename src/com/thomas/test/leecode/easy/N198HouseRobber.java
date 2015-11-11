package com.thomas.test.leecode.easy;

/**
 * 你是一个专业的强盗打算抢房子沿着街道。 每个房子都有一定数量的钱藏,唯一约束阻止你抢劫他们每个人是相邻房屋安全系统连接,
 * 它会自动联系警察如果两个相邻的房子被闯入在同一个晚上。 　　 　　 给定一个非负整数列表代表每个房子的钱,确定最大数量的钱你可以抢劫今晚没有通知警方抓获。
 * 
 * @author thomas
 * @time :2015年11月5日下午2:07:29
 */
public class N198HouseRobber {
	
	public static void main(String[] args) {
		System.out.println(rob(new int[]{10,40,72,9,13,99,129,337,296,4}));
	}
	/**
	 * 自己的解法，动态规划思想不太正确
	 * 
	 * @param houses
	 * @return
	 */
	public static int maxMoney(int[] houses) {
		if (null == houses)
			return 0;
		int currentMax = 0;
		int preMax = 0;
		int dis2Max = 0;
		int dis3Max = 0;
		for (int i = 0; i < houses.length; i++) {
			dis3Max = dis2Max;
			dis2Max = preMax;
			preMax = currentMax;
			currentMax = Math.max(dis2Max, dis3Max) + houses[i];
			System.out.println("currentMax : "+currentMax+" preMax : "+preMax+" dis2Max : "+dis2Max+ " dis3Max:"+dis3Max);
		}
		return Math.max(currentMax, preMax);
	}
	
	/**
	 * nice解法
	 * Include this house: i = num[k] + e 
	 * (money of this house + money robbed excluding the previous house)
	 * Exclude this house: e = max(i, e)
	 * (max of money robbed including the previous house or money robbed excluding the previous house)
	 *  
	 * @param num
	 * @return
	 */
	public static int rob(int[] num) {
	    int rob = 0; //max monney can get if rob current house
	    int notrob = 0; //max money can get if not rob current house
	    for(int i=0; i<num.length; i++) {
	        int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
	        notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
	        rob = currob;
	    }
	    return Math.max(rob, notrob);
	}

}
