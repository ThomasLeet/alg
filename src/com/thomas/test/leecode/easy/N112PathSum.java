package com.thomas.test.leecode.easy;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

/**
 * 给定一个二叉树和一个数,判断有一条root-to-leaf路径,其经过所有节点的和等于这个数的。
 * sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author thomas
 * @time :2015年11月6日下午3:36:01
 */
public class N112PathSum {
	
	public static void main(String[] args) {
		int[] src = new int[]{5,4,10,8,2,3,1,7,9};
		BinaryTree bt = new BinaryTree();
		for(int s : src){
			bt.add(s);
		}
		System.out.println(pathSum2(bt.root,14));
	}
	
	public static boolean pathSum2(Node node,int sum){
		if(node.left == null && node.right == null)
			return sum - node.value == 0;
		return null != node.left && pathSum2(node.left,sum-node.value) 
				|| null != node.right && pathSum2(node.right,sum-node.value);
	}

	public static boolean pathSum(Node node,int sum,int total){
		if(null == node){
			return sum == total;
		}
		sum += node.value;
		boolean left = pathSum(node.left,sum,total);
		boolean right = pathSum(node.right,sum,total);
		return left || right;
	}
}
