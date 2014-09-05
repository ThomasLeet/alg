package com.thomas.algorithm.mc100.base;

import java.util.LinkedList;

public class SimpleStack<E> {
	
	public LinkedList<E> link = new LinkedList<E>();
	
	public E pop() {
		return link.pop();
	}
	
	public void push(E e){
		link.push(e);
	}
	
	public E peek(){
		return link.peek();
	}
}
