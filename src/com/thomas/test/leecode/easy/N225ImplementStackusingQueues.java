package com.thomas.test.leecode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * 实现队列的如下功能
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * @author thomas
 * @time :2015年11月6日上午11:34:18
 */

public class N225ImplementStackusingQueues {
	
	Queue<Integer> queue =new LinkedList<Integer>();
	
	// Push element x onto stack.
    public void push(int x) 
    {
       queue.add(x);
       for(int i=0;i<queue.size()-1;i++)
       {
           queue.add(queue.poll());
       }
    }

    // Removes the element on top of the stack.
    public void pop() 
    {
        queue.poll();
    }

    // Get the top element.
    public int top() 
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() 
    {
        return queue.isEmpty();
    }
	
    //自己想的是在出栈的时候做文章
//	Queue<Integer> queue =new LinkedList<Integer>();
//	int lastSize = 0;
//	 // Push element x onto stack.
//    public void push(int x) {
//        queue.offer(x);
//        lastSize++;
//    }
//
//    // Removes the element on top of the stack.
//    public Integer pop() {
//        for(int i = 1 ; i < lastSize;i++){
//        	queue.offer(queue.poll());
//        }
//        lastSize--;
//        return queue.poll();
//    }
//
//    // Get the top element.
//    public Integer top() {
//    	for(int i = 1 ; i < lastSize;i++){
//        	queue.offer(queue.poll());
//        }
//    	Integer result = queue.peek();
//    	queue.offer(queue.poll());
//    	return result;
//    }
//
//    // Return whether the stack is empty.
//    public boolean empty() {
//        return queue.isEmpty();
//    }
}
