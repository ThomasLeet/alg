package com.thomas.algorithm.mc100.num4;

import java.util.LinkedList;
import java.util.List;

import com.thomas.algorithm.mc100.base.InitData;
import com.thomas.algorithm.mc100.base.TreeNode;

/**
 * 在二元树中找出和为某一值的所有路径 
 * 题目:输入一个整数和一棵二元树。 
 * 从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径。 
 * 打印出和与输入整数相等的所有路径。
 * 
 * 回溯法（backtracking）加 递归
 * 
 * 关键： 
 * 回溯的数组长度
 * @author thomas
 * @date 2014年9月5日
 */
public class Four {
	
	public static void main(String[] args) {
		int[] values = new int[]{10,5,12,4,7,8};
		TreeNode bst = InitData.makeBinarySearchTree(values);
		Four f = new Four();
		f.showPath(22,bst,0,0);
	}
	
	List<Integer> path = new LinkedList<Integer>();
	
	public void showPath(int total ,TreeNode tn,int sum,int index){
		if(null == tn)
			return;
		sum += tn.getValue();
		path.add(tn.getValue());
		if(sum < total){
			showPath(total,tn.getLeft(),sum,index);
			showPath(total,tn.getRight(),sum,index);
		}
		if(sum == total){
			StringBuilder sbdr = new StringBuilder();
			for(int value : path){
				sbdr.append(value).append(" ");
			}
			System.out.println(sbdr.toString());
		}
		sum = sum-tn.getValue();
		path.remove(index);
		return;
	}
}
