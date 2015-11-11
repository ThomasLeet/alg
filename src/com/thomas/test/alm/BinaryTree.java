package com.thomas.test.alm;

import java.util.Stack;

public class BinaryTree {

	public static class Node{
		public int total;
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(int value){
			this.total = 0;
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
	}
	
	public Node root;
	
	public boolean add(int value){
		if(null == root){
			root = toNode(value);
			return true;
		}
		boolean success = false;
		Node index = root;
		while(index != null){
			if(index.value > value){
				if(null == index.left){
					index.left = toNode(value);
					index.left.parent = index;
					success = true;
					break;
				}
				index = index.left;
			}else if(index.value < value){
				if(null == index.right){
					index.right = toNode(value);
					index.right.parent = index;
					success = true;
					break;
				}
				index = index.right;
			}else if(index.value == value){
				success = true;
				break;
			}
			
		}
		return success;
	}
	
	public int delete(int value){
		Node cursor = root;
		while(cursor != null){
			if(cursor.value > value){
				cursor = cursor.left;
				continue;
			}
			if(cursor.value < value){
				cursor = cursor.right;
				continue;
			}
			//删除（把右子树中最小的替换到此节点，否则把左边节点替换到此节点。如果没有子树直接删除）
			if(cursor.value == value){
				if(cursor.right != null){
					cursor.value = delete(min(cursor.right).value);
					return value;
				}
				if(cursor.left != null){
					cursor.value = delete(max(cursor.left).value);
					return value;
				}
				Node parent = cursor.parent;
				if( null != parent.left && parent.left.value == value)
					parent.left = null;
				else
					parent.right = null;
				return value;
			}
		}
		return -1;
	}
	
	/**
	 * 中序！！！
	 * @param start
	 */
	public void sort(Node start){
		Stack<Node> stack = new Stack<Node>();
		Node cursor = start;
		while(null != cursor || !stack.isEmpty()){
			while(null != cursor){
				stack.push(cursor);
				cursor = cursor.left;
			}
			if(!stack.isEmpty()){
				cursor = stack.pop();
				//中
				System.out.println(cursor.value);
				cursor = cursor.right;
			}
		}
	}
	
	public int maxDeep(){
		return traverseDeep(root);
	}
	
	private int traverseDeep(Node currentNode){
		if(null == currentNode)
			return 0;
		int leftDeep = 1+traverseDeep(currentNode.left);
		int rightDeep = 1+traverseDeep(currentNode.right);
		return Math.max(leftDeep, rightDeep);
	}
	
	public Node max(Node start){
		if(null == start)
			return null;
		Node cursor = start;
		while(cursor.right != null){
			cursor = cursor.right;
		}
		return cursor;
	}
	
	public Node min(Node start){
		if(null == start)
			return null;
		Node cursor = start;
		while(cursor.left != null){
			cursor = cursor.left;
		}
		return cursor;
	}
	
	public int floor(int value){
		return 0;
	}
	
	public int ceil(){
		return 0;
	}
	
	private Node toNode(int value){
		return new Node(value);
	}
	
	public static void main(String[] args) {
		int[] src = new int[]{5,4,10,8,2,3,1,7,9};
		BinaryTree bt = new BinaryTree();
		for(int s : src){
			bt.add(s);
		}
		System.out.println(bt.maxDeep());
		//bt.sort(bt.root);
		//System.out.println("fool : "+bt.floor(6));
//		bt.delete(9);
		//bt.sort(bt.root);
	}
	
}
