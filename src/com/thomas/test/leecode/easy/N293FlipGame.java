package com.thomas.test.leecode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 和你的朋友玩以下翻转游戏:给定一个字符串,该字符串包含只有两个字:+或-,
 * 你和你的朋友轮流抛两个连续的“++”到“——”。如果你们不能这么做(不存在连续+),然后他会输掉这场比赛。
 * 写一个函数来计算字符串的一次翻转后所有可能状态。
 * 例如,鉴于s =“++++”,一个动作后,它可能成为以下状态:
 * "--++", "+--+", "++--"
 * 
 * @author thomas
 * @time :2015年10月28日下午6:22:35
 */
public class N293FlipGame {
	
	public static void main(String[] args) {
		List<String> srcList = oneMove("++--+---+++-++");
		System.out.println(Arrays.toString(srcList.toArray(new String[srcList.size()])));
	}
	
	public static List<String> oneMove(String src){
		List<String> rst = new ArrayList<String>();
		if(null == src)
			return rst;
		int length = src.length();
		for(int i = 0 ; i+1 < length ; i++){
			if(src.charAt(i) == '+' && src.charAt(i+1) == '+'){
				String tem = src.substring(0, i)+"--"+src.substring(i+2, length);
				rst.add(tem);
			}
		}
		return rst;
	}
}
