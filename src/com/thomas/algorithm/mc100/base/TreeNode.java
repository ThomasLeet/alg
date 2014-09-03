package com.thomas.algorithm.mc100.base;

public class TreeNode {
	
	public int value;
	public TreeNode next;
	public TreeNode prev;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getNext() {
		return next;
	}

	public void setNext(TreeNode next) {
		this.next = next;
	}

	public TreeNode getPrev() {
		return prev;
	}

	public void setPrev(TreeNode prev) {
		this.prev = prev;
	}

}
