package com.thomas.test.leecode.easy;

import com.thomas.test.leecode.structure.ListNode;
/**
 * 已经排序的单链表，删除重复的节点
 * @author thomas
 * @time :2015年11月3日上午10:09:02
 */
public class N83RemoveDuplicatesfromSortedList {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		removeDuplicate(n1);
		ListNode cursor = n1;
		while(cursor != null){
			System.out.println(cursor.val);
			cursor = cursor.next;
		}
	}
	
	public static void removeDuplicate(ListNode node){
		ListNode repeatNode = null; 
		while(null != node){
			if(repeatNode != null && repeatNode.val == node.val){
				repeatNode.next = node.next;
			}else {
				repeatNode = node;
			}
			node = node.next;
		}
	}
}
