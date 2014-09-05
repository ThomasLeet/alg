package com.thomas.algorithm.mc100.base;

public class InitData {
	
	public static void main(String[] args) {
		makeBinarySearchTree();
	}
	
	public static TreeNode makeBinarySearchTree(int ... values){
		TreeNode root = new TreeNode();
		root.setValue(values[0]);
		for(int i = 1;i<values.length;i++){
			TreeNode tn = new TreeNode();
			tn.setValue(values[i]);
			addNode(root,tn);
		}
		
		readByInsertOrder(root,0);
		return root;
	}
	
	public static TreeNode makeBinarySearchTree(){
		TreeNode root = new TreeNode();
		root.setValue(10);
		int[] values =new int[]{1,5,8,16};
		for(int v : values){
			TreeNode tn = new TreeNode();
			tn.setValue(v);
			addNode(root,tn);
		}
		readNode(root);
		return root;
	}
	
	private static void addNode(TreeNode parentNode,TreeNode newNode){
		if(null == newNode)
			return;
		//不能将null引入下个递归里面赋值，因为赋值的是参数parentNode的引用，
		//不是parentNode的Right或者left
		/*if(null == parentNode)
			parentNode = newNode;*/
		if(newNode.getValue()>parentNode.getValue()){
			if(null == parentNode.getRight()){
				parentNode.setRight(newNode);
			}else{
				addNode(parentNode.getRight(),newNode);
			}
		}
		if(newNode.getValue()<parentNode.getValue()){
			if(parentNode.getLeft() == null){
				parentNode.setLeft(newNode);
			}else{
				addNode(parentNode.getLeft(),newNode);
			}
		}
		if(newNode.getValue()==parentNode.getValue())
			return;
	}
	
	/**
	 * 从大到小
	 */
	private static void readNode(TreeNode tn){
		if(null == tn)
			return;
		if(tn.getLeft() != null)
			readNode(tn.getLeft());
		System.out.println("node value is " + tn.getValue());
		if(tn.getRight() != null)
			readNode(tn.getRight());
	}
	
	/**
	 * 按二叉树的层一层一层打印
	 * @param tn
	 */
	private static void readByInsertOrder(TreeNode tn,int level){
		if(null ==tn)
			return;
		if(level==0)
			System.out.println(tn.value);
		if(tn.getLeft() != null)
			System.out.println(tn.getLeft().getValue());
		if(tn.getRight() != null)
			System.out.println(tn.getRight().getValue());
		if(tn.getLeft() != null){
			readByInsertOrder(tn.getLeft(),level++);
		}
		if(tn.getRight() != null){
			readByInsertOrder(tn.getRight(),level++);
		}
			
	}
	
}
