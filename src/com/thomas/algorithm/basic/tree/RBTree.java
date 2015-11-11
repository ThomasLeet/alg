package com.thomas.algorithm.basic.tree;


public class RBTree {
	
	public Entry root;
	
	/**
	 * 左旋：
	 * 是将此节点X位置为中心，将X的右节点放在此节点位置，然后将X放到自己左节点的位置。
	 * 然后将右子节点的左节点放到自己的右子节点。
	 */
	private void rotateLeft(Entry e) {
		Entry parent = parentOf(e);
		//父节点指向x的右子节点（Y）
		if(null == parent){
			root = e;
		}else if(parent.left.data == e.data){
			parent.left = e.right;
		}else if(parent.right.data == e.data){
			parent.right = e.right;
		}
	}
	
	private void rotateRight(Entry p) {
		
	}
	
	public class Entry{
		public int data;
		public Entry left;
		public Entry right;
		public Entry parent;
		public Color RED;
	}
	
	public enum Color{
		RED(1),
		BLACK(2);
		public int value;
		private Color(int value){
			this.value = value;
		}
		
	}
	
	public Entry parentOf(Entry e){
		return null == e || null == e.parent ? null : e.parent;
	}
	
	public Entry leftOf(Entry e){
		return null == e || null == e.left ? null : e.left;
	}
	
	public Entry rightOf(Entry e){
		return null == e || null == e.right ? null : e.right;
	}
	
}
