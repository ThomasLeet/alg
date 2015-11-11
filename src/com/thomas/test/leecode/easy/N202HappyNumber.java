package com.thomas.test.leecode.easy;
/**
 * 快乐的数量是一个数字定义为以下过程:
 * 从任何正整数,
 * 取数的每一位的平方和,并重复这个过程,直到数= 1(它将保持),或者它无休止地循环周期,不包括1。
 * 结果等于1的是就快乐的数。
 * 19 is a happy number
 * 1*1 + 9*9 = 82
 * 8*8 + 2*2 = 68
 * 6*6 + 8*8 = 100
 * 1*1 + 0*0 + 0*0 = 1
 * @author thomas
 * @time :2015年11月3日下午2:33:51
 */
public class N202HappyNumber {
	
	public static void main(String[] args) {
		System.out.println(isHappyNumber(21));
	}
	
	public static boolean isHappyNumber(int src){
		int value = src;
//		int loopTime = 0;
//		while(value != 1 && loopTime< 20){
//			value = sum(value);
//			loopTime ++;
//		}
		int slow = src;
		int fast = src;
		do{
			slow = sum(slow);
			fast = sum(fast);
			fast = sum(fast);
			System.out.println("slow : "+slow +", fast"+ fast);
			if(slow == 1 || fast == 1)
				break;
		}while(slow != fast);
		return slow != fast;
	}
	
	public static int sum(int src){
		int result = 0;
		StringBuilder sbr = new StringBuilder();
		while(src > 0){
			int tem = src % 10;
			sbr.append(tem+"*"+tem+" + ");
			result = result + tem*tem;
			src = src / 10;
		}
		if(sbr.length() > 0)
			sbr = sbr.delete(sbr.length() -2,sbr.length());
		System.out.println(sbr.toString() + "= "+result);
		return result;
	}
}
