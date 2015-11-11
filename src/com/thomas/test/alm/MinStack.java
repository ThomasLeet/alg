package com.thomas.test.alm;

public class MinStack {
	public MinElement[] data;
	public int size;
	public int top;

	public MinStack() {
		this.data = new MinElement[1000];
		this.size = 0;
		this.top = -1;
	}

	public int pop() {
		if (size == 0)
			return -1;
		int k = peek();
		data[top--] = null;
		size--;
		return k;
	}

	public void push(int obj) {
		checkSize(top + 1);
		int min = Integer.MAX_VALUE;
		if(size == 0){
			min = obj;
		}else{
			min = Math.min(obj, min());
		}
		MinElement me = new MinElement(obj, min);
		data[++top] = me;
		size++;
	}

	public int peek() {
		if(size == 0)
			return -1;
		return data[top].data;
	}

	public int min() {
		if(size == 0)
			return -1;
		return data[top].min;
	}

	public void checkSize(int index) {
		if (index >= 1000)
			throw new IndexOutOfBoundsException("out of index, size=" + size
					+ ",index=" + index);
	}

	public class MinElement {
		public int data;
		public int min;

		public MinElement(int data, int min) {
			this.data = data;
			this.min = min;
		}
	}

	public static void main(String[] args) {
		int[] src = new int[]{6,9,4,78,3,98,5,24,2};
		MinStack stack = new MinStack();
		for (int s : src) {
			stack.push(s);
		}
		while (stack.size > 0) {
			System.out.println(stack.peek()+","+stack.min());
			stack.pop();
		}

	}
}
