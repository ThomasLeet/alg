package com.thomas.test.leecode.easy;

import java.util.LinkedList;
import java.util.List;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 * 
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * @author thomas
 * @time :2015年11月12日下午2:49:10
 */
public class N257BinaryTreePaths {
	public static List<String> paths= new LinkedList<String>();
	
	public static void main(String[] args) {
		int[] src = new int[]{5,4,10,8,2,3,1,7,9};
		BinaryTree bt = new BinaryTree();
		for(int s : src){
			bt.add(s);
		}
		printAllPath(bt.root,"");
		for(String path : paths){
			System.out.println(path);
		}
	}
	
	public static void printAllPath(Node node,String path){
		if(node == null)
			return;
		if(node.left == null && node.right == null)
			paths.add(path+node.value);
		if(node.left != null)
			printAllPath(node.left,path+node.value+",");
		if(node.right != null)
			printAllPath(node.right,path+node.value+",");
	}
}
