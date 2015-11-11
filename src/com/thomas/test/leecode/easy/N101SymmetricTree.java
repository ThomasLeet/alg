package com.thomas.test.leecode.easy;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

/**
 * 给定一个二叉树,检查是否这是一个镜子本身(中心对称)
 *    1
 *   / \
 *  2   2
 * / \ / \
 *3  4 4  3
 *
 *这个不是对称
 *    1
 *   / \
 *  2   2
 *   \   \
 *   3    3
 * @author thomas
 * @time :2015年11月4日下午2:57:41
 */
public class N101SymmetricTree {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		Node rootLeft = new Node(2);
		Node rootRight = new Node(2);
		tree.root.left = rootLeft;
		tree.root.right = rootRight;
		Node rootLeftLeft = new Node(3);
		Node rootRightLeft = new Node(3);
		rootLeft.left= rootLeftLeft;
		rootRight.left = rootRightLeft;
		System.out.println(isSymmetricTree(rootLeft,rootRight));
	}

	public static boolean isSymmetricTree(Node node1,Node node2){
		if(node1 == null && node2 == null)
			return true;
		if(node1 != null && node2 != null){
			if(node1.value != node2.value)
				return false;
			boolean left = isSymmetricTree(node1.left,node2.right);
			boolean right = isSymmetricTree(node1.right,node2.left);
			return left && right;
		}
		return false;
	}
}
