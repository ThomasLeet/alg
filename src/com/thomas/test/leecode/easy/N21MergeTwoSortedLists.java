package com.thomas.test.leecode.easy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import com.thomas.test.leecode.structure.ListNode;

/**
 * 合并两个有序链表并返回一个新的列表。新列表应该由连接在一起的节点前两个列表。
 * 
 * @author thomas
 * @time :2015年11月4日上午10:12:12
 */
public class N21MergeTwoSortedLists {

	public static void main(String[] args) {
//		LinkedList<Integer> list1 = new LinkedList<Integer>();
//		LinkedList<Integer> list2 = new LinkedList<Integer>();
//		list1.add(1);list1.add(1);
//		list1.add(3);list1.add(3);
//		list1.add(10);
//		list2.add(1);list2.add(2);
//		list2.add(3);list2.add(4);
//		list2.add(5);list2.add(6);
//		LinkedList<Integer> result = merge(list1,list2);
//		System.out.println(Arrays.toString(result.toArray(new Integer[result.size()])));
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode nn1 = new ListNode(1);
		ListNode nn2 = new ListNode(1);
		ListNode nn3 = new ListNode(6);
		ListNode nn4 = new ListNode(10);
		nn1.next = nn2;
		nn2.next = nn3;
		nn3.next = nn4;
		ListNode cursor = merage(n1,nn1);
		//ListNode cursor = recursive(n1,null);
		while(cursor != null){
			System.out.println(cursor.val);
			cursor = cursor.next;
		}
	}
	
	public static ListNode merage(ListNode node1,ListNode node2){
		if(null == node1)
			return node2;
		if(null == node2)
			return node1;
		ListNode newNode = new ListNode(0);
		ListNode start = newNode;
		while(node1 != null && node2 != null){
			if(node1.val <= node2.val){
				newNode.next = node1;
				node1 = node1.next;
			}else{
				newNode.next = node2;
				node2 = node2.next;
			}
			newNode = newNode.next;
		}
		if(node1 == null)
			newNode.next = node2;
		if(node2 == null)
			newNode.next = node1;
		return start.next;
	}

	/**
	 * 自己实现方向不对，可以不创建新链表
	 * @param one
	 * @param two
	 * @return
	 */
	public static LinkedList<Integer> merge(LinkedList<Integer> one,
			LinkedList<Integer> two) {
		LinkedList<Integer> newList = new LinkedList<Integer>();
		if (null == one || one.isEmpty() && null == two || two.isEmpty())
			return newList;
		if (null == one || one.isEmpty())
			return two;
		if (null == two || two.isEmpty())
			return one;
		Iterator<Integer> oneIt = one.iterator();
		Iterator<Integer> twoIt = two.iterator();
		Integer temOne = oneIt.next();
		Integer temTwo = twoIt.next();
		do {
			if(null == temOne){
				newList.add(temTwo);
				temTwo = twoIt.hasNext() ? twoIt.next() : null;
				continue;
			}
			if(null == temTwo){
				newList.add(temOne);
				temOne = oneIt.hasNext() ? oneIt.next() : null;
				continue;
			}
			if(temOne.intValue() <= temTwo.intValue()){
				newList.add(temOne);
				temOne = oneIt.hasNext() ? oneIt.next() : null;
			}else{
				newList.add(temTwo);
				temTwo = twoIt.hasNext() ?  twoIt.next() : null;
			}
		}while(null != temOne || null != temTwo);
		return newList;
	}
}
