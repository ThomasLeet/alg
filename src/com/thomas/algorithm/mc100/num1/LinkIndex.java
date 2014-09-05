package com.thomas.algorithm.mc100.num1;

import com.thomas.algorithm.mc100.base.TreeNode;

public class LinkIndex {
	
	public TreeNode head;
	public TreeNode tail;
	
	public LinkIndex(){
	}
	
	public LinkIndex(TreeNode head,TreeNode tail){
		this.head = head;
		this.tail = tail;
	}
	
	public TreeNode getHead() {
		return head;
	}
	public void setHead(TreeNode head) {
		this.head = head;
	}
	public TreeNode getTail() {
		return tail;
	}
	public void setTail(TreeNode tail) {
		this.tail = tail;
	}
	
	
}
