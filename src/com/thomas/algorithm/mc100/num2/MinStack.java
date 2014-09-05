package com.thomas.algorithm.mc100.num2;

import com.thomas.algorithm.mc100.base.SimpleStack;

public class MinStack {
	SimpleStack<Integer> stack = new SimpleStack<Integer>();
	SimpleStack<Integer> minStack = new SimpleStack<Integer>();
	int min = Integer.MAX_VALUE;
	int count = 0;
	
	public int pop() {
		if(count ==0)
			throw new IndexOutOfBoundsException("stack已经为空");
		minStack.pop();
		int num = stack.pop();
		count--;
		return num;
	}
	
	public void push(int e){
		if(e<min)
			min = e;
		minStack.push(min);
		stack.push(e);
		count++;
	}
	
	public int min(){
		if(count == 0)
			throw new NullPointerException("stack为空");
		return minStack.peek();
	}
}
