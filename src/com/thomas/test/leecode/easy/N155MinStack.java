package com.thomas.test.leecode.easy;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time. 
 * push(x) -- Push element x onto stack. 
 * pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 自己的思路：
 * 1.如果入栈的数比min小的话，把之前的min也入栈
 * 2.出栈的时候判断如果出栈前的值和min相等，就再出栈一次取下个min
 * 
 * @author thomas
 * @time :2015年11月13日下午1:42:32
 */
public class N155MinStack {
	
	public static void main(String[] args) {
		int[] src = new int[]{5,5,2,3,1};
		for(int s : src){
			push(s);
		}
		for(int i = 0 ; i< src.length;i++){
			System.out.println(top()+"|"+min);
			pop();
		}
	}
	
	public static Stack<Integer> stack = new Stack<Integer>();
	public static int min = Integer.MAX_VALUE;
	
	public static void push(int x) {
		if(stack.isEmpty()){
			stack.push(0);
			min = x;
			stack.push(x);
		}else{
			if(x <= min){//注意有等于，因为有连续两个最小值的问题
				stack.push(min);
				min = x;
			}
			stack.push(x);
		}
	}

	public static void pop() {
		if(stack.isEmpty())
			return;
		int peek = stack.peek();
		stack.pop();
		if(peek == min){
			min = stack.pop();
		}
	}

	public static int top() {
		return stack.peek();
	}

	public static int getMin() {
		return min;
	}
}
