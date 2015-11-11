package com.thomas.test.alm;


public class Stack<K> {
	public Object[] data;
	public int size;
	public int top;
	
	public Stack(){
		this.data = new Object[1000];
		this.size = 0;
		this.top = -1;
	}
	
	public K pop(){
		K k =  peek();
		data[top--] = null;
		size--;
		return k;
	}
	
	public void push(K obj){
		data[++top] = obj;
		size++;
	}
	
	@SuppressWarnings("unchecked")
	public K peek(){
		return (K)data[top];
	}
	
	public void checkSize(int index){
		if(index >= size)
			throw new IndexOutOfBoundsException("out of index, size="+size+",index="+index);
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 1;i<=100;i++){
			stack.push(i);
		}
		while (stack.size>0) {
			System.out.println(stack.pop());
		}
		
	}
}
