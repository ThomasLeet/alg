package com.thomas.test.leecode.easy;

/**
 * 编写一个函数来删除一个节点(尾部除外)在一个单链表,只提供待删除节点。
 * 该链表是1 - > 2 - > 3 - > 4和给你第三个节点值为3,调用你的函数后链表应该成为1 - > 2 - > 4。
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 * @author thomas
 * @time :2015年10月29日上午10:42:10
 */
public class N237DeleteNodeinaLinkedList {

	public static void deleteNode(ListNode node){
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
		next = null;
	}
	
	 public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
