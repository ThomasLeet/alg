package com.thomas.test.leecode.easy;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

/**
 * 给定一个非空二叉搜索树和目标价值,找到最接近的BST的值。 　　
 * 注意: 　　
 * 给定的目标值是一个浮点数。 　　
 * 只有唯一个最接近目标的值;
 * @author thomas
 * @time :2015年11月6日上午10:54:22
 */
public class N270ClosestBinarySearchTreeValue {
	
	public static void main(String[] args) {
		//int[] src = new int[]{5,4,10,8,2,3,1,7,9};
		int[] src = new int[]{100,90,120,95,109};
		BinaryTree bt = new BinaryTree();
		for(int s : src){
			bt.add(s);
		}
		System.out.println(closestNode(bt.root,104));
	}
	
	public static int closestNode(Node node,int target){
		int currentVal = node.value;
		Node nextNode = node.value > target ? node.left : node.right;
		if(nextNode == null)
			return currentVal;
		int childVal = closestNode(nextNode,target);
		return Math.abs(currentVal-target) < Math.abs(childVal-target) ? currentVal : childVal;
	}
}
