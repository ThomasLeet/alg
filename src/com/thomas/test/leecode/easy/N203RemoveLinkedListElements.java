package com.thomas.test.leecode.easy;

import com.thomas.test.leecode.structure.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author thomas
 * @time :2015年11月10日下午6:08:28
 */
public class N203RemoveLinkedListElements {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode cursor = remove(n1,1);
		//ListNode cursor = recursive(n1,null);
		while(cursor != null){
			System.out.println(cursor.val);
			cursor = cursor.next;
		}
		if(cursor == null){
			System.out.println("null");
		}
	}
	
	public static ListNode remove(ListNode node,int val){
		if(null == node)
			return null;
		ListNode start = node;
		while(start != null && start.val == val){
			start = start.next;
		}
		ListNode cursor = start;
		while(cursor != null){
			if(null != cursor.next && cursor.next.val == val){
				cursor.next = cursor.next.next;
			}
			cursor = cursor.next;
		}
		return start;
	}
}
