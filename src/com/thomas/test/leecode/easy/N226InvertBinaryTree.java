package com.thomas.test.leecode.easy;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

/**
 * 翻转二叉树
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

 * @author thomas
 * @time :2015年10月29日下午4:14:47
 */
public class N226InvertBinaryTree {
	
	public static void main(String[] args) {
		int[] src = new int[]{5,4,10,8,2,3,1,7,9};
		BinaryTree bt = new BinaryTree();
		for(int s : src){
			bt.add(s);
		}
		
		bt.sort(bt.root);
		invertBT(bt.root);
		System.out.println("=====");
		bt.sort(bt.root);
	}
	
	public static void invertBT(Node node){
		if(null == node)
			return;
		Node tem = node.left;
		node.left = node.right;
		node.right = tem;
		invertBT(node.left);
		invertBT(node.right);
	}
}
