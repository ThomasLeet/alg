package com.thomas.test.leecode.easy;

import java.util.Stack;

/**
 * 使用栈实现一个队列。
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * 注: 　　
 * 你必须只使用标准操作堆栈,这意味着只有努力,peek /流行从上,大小,是空的操作是有效的。 　　
 * 根据你的语言,堆栈可能不支持stack。你可以模拟一个堆栈使用列表或双端队列(双头队列),只要你只使用一个堆栈的标准操作。 　　
 * 你可能会假定所有操作是有效的(例如,no pop or peek operations will be called on an empty queue)。
 * @author thomas
 * @time :2015年11月3日上午10:46:53
 */
public class N232ImplementQueueUsingStacks {
	
	public static void main(String[] args) {
		N232ImplementQueueUsingStacks queue = new N232ImplementQueueUsingStacks();
		queue.push(0);
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		while(!queue.empty()){
			System.out.println(queue.pop());
		}
	}
	
	Stack<Integer> input = new Stack<Integer>();
	Stack<Integer> output= new Stack<Integer>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        if(output.empty()){
        	input2Output();
        }
        return output.pop();
    }

    // Get the front element.
    public int peek() {
        if(output.empty())
        	input2Output();
        return output.peek();
    }
    
    public void input2Output(){
    	while(!input.empty()){
    		output.push(input.pop());
    	}
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.empty() && output.empty();
    }
	
}
