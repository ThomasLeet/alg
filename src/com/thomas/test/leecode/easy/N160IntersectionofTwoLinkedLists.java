package com.thomas.test.leecode.easy;

import com.thomas.test.leecode.structure.ListNode;

/**
 * 找到两个有合并部分单链表的交叉点。
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * 注意：
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * @author thomas
 * @time :2015年11月6日下午5:00:17
 */
public class N160IntersectionofTwoLinkedLists {
	
	public static void main(String[] args) {
		ListNode n11 = new ListNode(1);
		ListNode n12 = new ListNode(2);
		ListNode n13 = new ListNode(10);
		ListNode n14 = new ListNode(11);
		ListNode n15 = new ListNode(12);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		ListNode n21 = new ListNode(4);
		ListNode n22 = new ListNode(5);
		ListNode n23 = new ListNode(6);
		ListNode n24 = new ListNode(10);
		ListNode n25 = new ListNode(11);
		ListNode n26 = new ListNode(12);
		n21.next = n22;
		n22.next = n23;
		n23.next = n24;
		n24.next = n25;
		n25.next = n26;
		ListNode common = commonNode1(n11,n21);
		if(null != common)
			System.out.println(common.val);
		else
			System.out.println("null");
	}
	
	public static ListNode commonNode1(ListNode n1, ListNode n2){
		ListNode s1 = n1;
		ListNode s2 = n2;
		if(null == n1 || null == n2)
			return null;
		while(n1.val != n2.val){
			n1 = n1.next == null ? s2 : n1.next;
			n2 = n2.next == null ? s1 : n2.next;
		}
		return n1;
	}
}
