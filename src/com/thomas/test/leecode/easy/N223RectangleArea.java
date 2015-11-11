package com.thomas.test.leecode.easy;

/**
 * 找到总面积由两直线矩形在二维平面上
 * 定义每个矩形的左下角和右上角如图。
 * 假设总面积是永远不会超出int的最大可能值
 * https://leetcode.com/problems/rectangle-area/ 
 */
public class N223RectangleArea {
	
	public static void main(String[] args) {
		System.out.println(commonArea(new int[]{-10,-1},new int[]{3,2},new int[]{1,-9},new int[]{10,2}));
	}
	
	public static int commonArea(int[] s1l,int[] s1r,int[] s2l,int[] s2r){
		int rx = Math.min(s2r[0], s1r[0]);
		int ry = Math.min(s2r[1], s1r[1]);
		int lx = Math.max(s2l[0], s1l[0]);
		int ly = Math.max(s2l[1], s1l[1]);
		System.out.println(rx+","+ry +"|"+lx+","+ly);
		return (rx - lx) * (ry - ly);
	}
}
