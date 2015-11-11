package com.thomas.test.leecode.easy;

/**
 * 给定的数组大小为n,找出出现次数超过n / 2的元素。
 * 你可能认为数组非空,而且总有一个这样的元素存在于数组中。
 * @author thomas
 * @time :2015年10月30日下午4:19:18
 */
public class N169MajorityElement {
	
	public static void main(String[] args) {
		System.out.println(wrong(new int[]{1,1,1,2,2,3,1}));
	}
	
	/**
	 * 摩尔投票算法
	 * 这个算法必要条件是必须有超半数的数存在，否则不准！！！
	 * @param num
	 * @return
	 */
	public static int wrong(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;

        }
        return major;
    }
	
	/**
	 * 不是最佳算法，但是思路新颖
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			int ones = 0, zeros = 0;
			for (int j = 0; j < num.length; j++) {
				if ((num[j] & (1 << i)) != 0) {
					++ones;
				} else
					++zeros;
			}
			if (ones > zeros)
				ret |= (1 << i);
		}
		return ret;
	}
}
