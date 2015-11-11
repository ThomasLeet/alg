package com.thomas.test.leecode.easy;

import java.util.HashSet;

/**
 * 数独规则：
 * 数独盘面是个九宫，每一宫又分为九个小格。在这八十一格中给出一定的已知数字和解题条件，利用逻辑和推理，
 * 在其他的空格上填入1-9的数字。使1-9每个数字在每一行、每一列和每一宫中都只出现一次，所以又称“九宫格”。
 * 题目：
 * 注意到题目中说的,只要当前已经填充的数字是合法的就可以,不一定要这个数独是有解.（下面说的九宫格都是指3*3的网格）
 * 因此只需要判断9*9网格的每一行、每一列、9个小九宫格是否合法。即如果在每一行、每一列、每个9个小九宫格内，某个数字重复出现了，当前数独就是不合法的。
 * 网上很多解法是：行、列、九宫格、分三个两重循环来分别判断是否合法。其实只需要一个两重循环即可
 * 需要注意的是： 如果把九宫格按照行从0开始标号，那么数字board[i][j] 位于第 i/3*3+j/3 个九宫格内
 * @author thomas
 * @time :2015年11月10日上午11:27:36
 */
public class N36ValidSudoku {
	
	public static boolean vaild(char[][] src){
		for(int x = 0 ;x <= 8;x++){
			if(!v(src,x,0,x,8))
				return false;
		}
		for(int y = 0 ;y <= 8;y++){
			if(!v(src,0,y,8,y))
				return false;
		}
		for(int x = 0;x < 3;x++){
			for(int y = 0;y < 3;y++){
				if(!v(src,x*3,y*3,x*3+2,y*3+2))
					return false;
			}
		}
		return true;
	}
	
	public static boolean v(char[][] src,int x1,int y1,int x2,int y2){
		HashSet<Character> tem = new HashSet<Character>();
		for(int i = x1 ; i <= x2;i++){
			for(int j = y1;j <= y2 ;j++){
				if(src[i][j] != '.'){
					if(!tem.add(src[i][j]))
						return false;
				}
			}
		}
		return true;
	}
}
