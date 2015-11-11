package com.thomas.test.leecode.easy;

import com.thomas.test.leecode.structure.ListNode;

/**
 * 翻转一个单链表
 * 
 * @author thomas
 * @time :2015年11月2日下午2:08:09
 */
public class N206ReverseLinkedList {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode cursor = reversLinkedList(n1);
		//ListNode cursor = recursive(n1,null);
		while(cursor != null){
			System.out.println(cursor.val);
			cursor = cursor.next;
		}
	}

	public static ListNode reversLinkedList(ListNode node){
		ListNode newNext = null;
		while(node != null){
			ListNode tem = node.next;
			node.next = newNext;
			newNext = node;
			node = tem;
		}
		return newNext; 
	}
	
	public static ListNode recursive(ListNode node,ListNode next){
		if(null == node)
			return next;
		ListNode newNext = node.next;
		node.next = next;
		return recursive(newNext,node);
	}
	
}
