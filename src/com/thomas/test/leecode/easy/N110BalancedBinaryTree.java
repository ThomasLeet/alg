package com.thomas.test.leecode.easy;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

/**
 * 给定一个二叉树,确定它是高度平衡。 　　 　
 * 对于这个问题,一个高度平衡二叉树的定义是一棵二叉树中,每个节点的两个子树的深度不会相差超过1。
 * @author thomas
 * @time :2015年11月4日下午12:10:18
 */
public class N110BalancedBinaryTree {
	
	public static void main(String[] args) {
		//int[] src = new int[]{5,4,10,8,2,3,1,7,9};
		int[] src = new int[]{5,3,10,1,4,9,11};
		BinaryTree bt = new BinaryTree();
		for(int s : src){
			bt.add(s);
		}
		System.out.println(distance(bt.root,0));
	}
	//自己的nice解法！ 
	public static int distance(Node node,int deep){
		if(node == null)
			return deep;
		deep += 1;
		int left = distance(node.left,deep);
		int right = distance(node.right,deep);
		if(left < 0 || right < 0)
			return -1;
		if(left > right && left - right >1 || right > left && right - left > 1)
			return -1;
		return Math.max(left, right);
	}
	}
