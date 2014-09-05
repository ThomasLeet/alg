package com.thomas.algorithm.mc100.num2;


/**
 * 设计包含 min 函数的栈。
 * 定义栈的数据结构,要求添加一个 min 函数,能够得到栈的最小元素。 要求函数 min、push 以及 pop 的时间复杂度都是 O(1)。
 * 
 * 注意，出栈入栈的元素数量检查
 * @author thomas
 * @date 2014年9月4日
 */
public class Two {
	
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		int[] nums = new int[]{10,2,1,4,0,6,7};
		for(int num : nums){
			ms.push(num);
		}
		int i = 0;
		while(i<nums.length){
			System.out.println(ms.min());
			ms.pop();
			i++;
		}
		
	}
	
}
