package com.thomas.test.leecode.easy;

import com.thomas.test.leecode.structure.ListNode;

/**
 * 给一个单链表，判断是否是回文
 * Could you do it in O(n) time and O(1) space?
 * @author thomas
 * @time :2015年11月12日上午10:59:21
 */
public class N234PalindromeLinkedList {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		System.out.println( isPalindrome(n1));
	}
	
	public static boolean isPalindrome(ListNode root){
		if(null == root)
			return false;
		ListNode oneStep = root;
		ListNode twoStep = root;
		while(twoStep.next != null && twoStep.next.next != null){
			oneStep = oneStep.next;
			twoStep = twoStep.next.next; 
		}
		ListNode halfStart = reverseLink(oneStep.next);
		ListNode checkNode = root;
		while(halfStart != null){
			if(halfStart.val != checkNode.val)
				return false;
			halfStart = halfStart.next;
			checkNode = checkNode.next;
		}
		return true;
	}
	
	public static ListNode reverseLink(ListNode node){
		if(null == node)
			return node;
		ListNode newNext = null;
		ListNode head = node;
		while(head != null){
			ListNode tem = head.next;
			head.next = newNext;
			newNext = head;
			head = tem;
		}
		return newNext;
	}
}
