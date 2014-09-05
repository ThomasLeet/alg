package com.thomas.algorithm.mc100.num1;

import com.thomas.algorithm.mc100.base.InitData;
import com.thomas.algorithm.mc100.base.TreeNode;

/**
 * 把二元查找树转变成排序的双向链表(树)
 * @author thomas
 * @date 2014年9月3日
 */
public class one {
	
	public static void main(String[] args) {
		TreeNode node = InitData.makeBinarySearchTree();
		LinkIndex link = transToLink(node);
		TreeNode head = link.getHead();
		while(head != null){
			System.out.println(head.getValue());
			head = head.getRight();
		}
	}
	
	/**
	 * 方法参数中的属性可以在方法中修改，但是参数本身的对象不能修改。
	 * 因为修改参数的对象只在本方法中有效
	 * 例如 A 中调用 tran(a);
	 * 方法tran(Object obj)中修改obj对象的属性可以，但是obj= new Object()对a无效，因为obj是指针，只修改了obj的指向，没有修改a的指向。
	 * @param node
	 * @return
	 */
	public static LinkIndex transToLink(TreeNode node){
		TreeNode lt,rt;
		if(null == node)
			return null;
		if(node.getLeft()!=null){
			LinkIndex ltIndex = transToLink(node.getLeft());
			//赋值lt
			lt = ltIndex.head;
			//交换节点
			ltIndex.tail.setRight(node);
			node.setLeft(node.left.right);
		}else{
			lt = node;
		}
		if(node.getRight()!=null){
			LinkIndex rtIndex = transToLink(node.getRight());
			//赋值rt
			rt= rtIndex.tail;
			//交换节点
			rtIndex.head.setLeft(node);
			node.setRight(rtIndex.head);
		}else{
			rt = node;
		}
		return new LinkIndex(lt,rt);
			
	}
}
