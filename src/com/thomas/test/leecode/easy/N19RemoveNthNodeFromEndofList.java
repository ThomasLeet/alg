package com.thomas.test.leecode.easy;

import com.thomas.test.leecode.structure.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * @author thomas
 * @time :2015年11月10日下午2:40:45
 */
public class N19RemoveNthNodeFromEndofList {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode cursor = removeNthNode(n1,2);
		//ListNode cursor = recursive(n1,null);
		while(cursor != null){
			System.out.println(cursor.val);
			cursor = cursor.next;
		}
	}
	
	public static ListNode removeNthNode(ListNode node,int step){
		if(null == node || step <= 0)
			return node;
		ListNode frontNode = node;
		ListNode backNode = null;
		int temStep = step;
		while(frontNode != null){
			if(temStep == 0){
				backNode = null == backNode ? node : backNode.next;
			}
			frontNode = frontNode.next;
			if(temStep > 0)
				temStep--;
		}
		if(null != backNode){
			if(step == 1){
				backNode.val = backNode.next.val;
				backNode.next = null;
			}else if(step > 1){
				backNode.val = backNode.next.val;
				backNode.next = backNode.next.next;
			}
		}
		return node;
	}
}
