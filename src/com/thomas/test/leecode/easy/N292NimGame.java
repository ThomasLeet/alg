package com.thomas.test.leecode.easy;

/**
 * 你和你的朋友玩游戏玩取物游戏: 有一堆石头放在桌上,每次你们轮流删除1到3个石头。删除最后一个石头的人将会成为赢家。 你将第一个删除的石头。 　
 * 写一个函数来确定你是否能赢得这场比赛在指定数量的石头中。
 * 例如,如果有四堆石头,那么你永远不会赢得比赛:无论1、2、或3石头你删除最后一个石头总是会被你的朋友。 Hint：
 * 如果在堆中有5个石头,你能想办法把石头,这样你将永远是赢家?
 * 
 * @author thomas
 * @time 2015年10月28日下午3:34:59
 */
public class N292NimGame {
	public static void main(String[] args) {
		System.out.println(win(13));
	}

	public static boolean win(int stoneTotal) {
		return stoneTotal%4 > 0;
	}

}
