package com.thomas.test.leecode.easy;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

/**
 * 给定两个二叉树,编写一个函数来检查是否他们是相等的。
 * 两个二叉树,如果他们被认为是相等的,在结构上是相同的,节点有相同的价值。
 * @author thomas
 * @time :2015年10月29日下午1:59:36
 */
public class N100SameTree {
	public static boolean isSame(Node node1,Node node2){
			if(null == node1 && null != node2 || null != node1 && null == node2){
				return false;
			}
			if(null == node1 && null == node2)
				return true;
			if(node1.value != node2.value)
				return false;
			boolean leftSame = isSame(node1.left,node2.left);
			if(!leftSame)
				return leftSame;
			boolean rightSame = isSame(node1.right,node2.right);
			if(!rightSame)
				return rightSame;
			return true;
	}

	// 答案（简洁版）
	public boolean isSameTree(Node p, Node q) {
		if (p == null && q == null)
			return true;
		return p != null && q != null && p.value == q.value
				&& isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	public static void main(String[] args) {
		int[] src = new int[]{5,4,10,8,2,3,1,7,9};
		BinaryTree bt = new BinaryTree();
		for(int s : src){
			bt.add(s);
		}
		int[] src2 = new int[]{5,4,10,8,2,3,1,7,16};
		BinaryTree bt2 = new BinaryTree();
		for(int s : src2){
			bt2.add(s);
		}
		System.out.println(isSame(bt.root,bt2.root));
	}
}
