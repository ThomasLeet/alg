package com.thomas.test.leecode.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author thomas
 * @time :2015年11月10日下午4:22:01
 */
public class N20ValidParentheses {
	
	public static void main(String[] args) {
		System.out.println(valid("[]({({}())})"));
	}
	
	public static boolean valid(String src){
		char[] srcAry = src.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0 ; i< srcAry.length; i++){
			if(srcAry[i] == '(' || srcAry[i] == '{' || srcAry[i] == '['){
				stack.push(srcAry[i]);
			}
			if(srcAry[i] == ')' || srcAry[i] == '}' || srcAry[i] == ']'){
				if(stack.isEmpty())
					return false;
				if(srcAry[i] == ')' && stack.pop() != '(' ||
						srcAry[i] == '}' && stack.pop() != '{' ||
						srcAry[i] == ']' && stack.pop() != '[')
					return false;
			}
		}
		return true;
	}
}
