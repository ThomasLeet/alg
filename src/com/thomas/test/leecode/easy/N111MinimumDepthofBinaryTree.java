package com.thomas.test.leecode.easy;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

public class N111MinimumDepthofBinaryTree {
	
	public static void main(String[] args) {
		int[] src = new int[]{5,4,10,8,2,7,9};
		BinaryTree bt = new BinaryTree();
		for(int s : src){
			bt.add(s);
		}
		//System.out.println(minDeep(bt.root,0));
		System.out.println(minDepth(bt.root));
	}
	//自己的
	public static int minDeep(Node node,int level){
		if(node == null)
			return level;
		if(null == node.left && null == node.right)
			return level;
		if(null != node.left && null != node.right){
			int left = minDeep(node.left,level + 1);
			int right = minDeep(node.right,level + 1);
			return Math.min(left, right);
		}
		return null == node.left ? minDeep(node.right,level + 1) : minDeep(node.left,level + 1);
	}
	
	public static int minDepth(Node root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }
}
