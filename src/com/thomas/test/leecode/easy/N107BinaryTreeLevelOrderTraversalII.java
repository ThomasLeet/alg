package com.thomas.test.leecode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.thomas.test.alm.BinaryTree;
import com.thomas.test.alm.BinaryTree.Node;

/**
 * 给定一个二叉树,返回自底向上的层次顺序遍历节点的值。即,一层一层从左到右,从叶到根
 * 
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 返回
 *  [
 *		[15,7],
 *		[9,20],
 *		[3]
 *  ]
 * @author thomas
 * @time :2015年11月4日下午4:48:30
 */
public class N107BinaryTreeLevelOrderTraversalII {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		Node rootLeft = new Node(21);
		Node rootRight = new Node(22);
		tree.root.left = rootLeft;
		tree.root.right = rootRight;
		Node rootLeftLeft = new Node(31);
		Node rootRightLeft = new Node(32);
		rootLeft.left= rootLeftLeft;
		rootRight.left = rootRightLeft;
		int[][] result = levelNode(tree.root);
		for(int[] r : result){
			System.out.println(Arrays.toString(r));
		}
	}
	
	public List<List<Integer>> leveNodeDFS(Node root){
		Queue<Node> queue = new LinkedList<Node>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        if(null == root)
        	return wrapList;
        queue.offer(root);
        while(!queue.isEmpty()){
        	List<Integer> level = new LinkedList<Integer>();
        	int size = queue.size();
        	for(int i = 0 ; i< size ; i++){
        		if(null != queue.peek().left)
        			queue.add(queue.peek().left);
        		if(null != queue.peek().right)
        			queue.add(queue.peek().right);
        		level.add(queue.poll().value);
        	}
        	wrapList.add(level);
        }
        return wrapList;
	}
	
	@Deprecated
	public static int[][] levelNode(Node node){
		if(null == node)
			return new int[0][0];
		int[][] left = levelNode(node.left);
		int[][] right = levelNode(node.right);
		int[][] current = new int[Math.max(left.length, right.length)+1][];
		for(int i = 0 ;i < current.length-1;i++){
			int leftLength = 0;
			int rightLength = 0;
			if(left.length > i){
				leftLength = left[i].length;
			}
			if(right.length > i){
				rightLength = right[i].length;
			}
			int[] currentNode = new int[leftLength+rightLength];
			if(left.length > i){
				System.arraycopy(left[i], 0, currentNode, 0, leftLength);
			}
			if(right.length > i){
				System.arraycopy(right[i], 0, currentNode, leftLength == 0 ? 0 : leftLength-1, rightLength);
			}
			current[i] = currentNode;
		}
		current[current.length-1]= new int[]{node.value};
		return current;
	}
}
