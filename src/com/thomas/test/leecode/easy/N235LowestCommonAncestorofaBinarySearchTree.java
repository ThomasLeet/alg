package com.thomas.test.leecode.easy;

import com.thomas.test.alm.BinaryTree.Node;

/**
 * 给定一个二叉搜索树(BST),找到最低的共同祖先(LCA)的两个给定节点在BST。
 * 允许一个节点的后代是自己。
 *      _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
 *
 *例如,最低的共同祖先(LCA)的节点2和8是6。另一个例子是LCA的节点2和4是2,根据LCA定义一个节点可以是本身的后裔。
 * @author thomas
 * @time :2015年10月30日上午10:27:52
 */
public class N235LowestCommonAncestorofaBinarySearchTree {
	//方法一，先找到两个节点，然后找他们路径上最近的公共节点。
	//方法二，从root结点开始找最近的分叉口！
	public static Node commonNode(Node node,Node n1,Node n2){
		if(null == n1 || null == n2)
			throw new IllegalArgumentException();
		while((node.value-n1.value)*(node.value-n2.value) > 0){
			node =  node.value > n1.value ? node.left : node.right;
		}
		return node;
	}
	
}