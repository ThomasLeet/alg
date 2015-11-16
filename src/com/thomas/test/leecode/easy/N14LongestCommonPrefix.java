package com.thomas.test.leecode.easy;

/**
 * 编写一个函数来找到最长公共前缀字符串在字符串数组。
 * @author thomas
 * @time :2015年11月11日下午4:00:10
 */
public class N14LongestCommonPrefix {
	
	
	public static void main(String[] args) {
		String[] src = new String[]{
			"thomas",
			"thomaslee",
			"thomaslee007",
			"thomas_lee",
			"thomas_ellen",
			"thomas_",
		};
		System.out.println(longestCommonNice(src));
	}
	
	//思路不对,可以从后往前比对
	public static String longestCommon(String[] src){
		if(null == src)
			return "";
		StringBuilder sbr = new StringBuilder();
		boolean canSearch = true;
		for(int i = 0 ; canSearch ;i++ ){//prefixIndex
			Character common = null;
			boolean isCommon = true;
			for(int j = 0;j < src.length ;j++){
				if(src[j].length() <= i){
					canSearch = false;
					isCommon = false;
					break;
				}
				if(null == common)
					common = src[j].charAt(i);
				else if(common != src[j].charAt(i)){
					isCommon = false;
					canSearch = false;
					break;
				}
			}
			if(null != common && isCommon){
				sbr.append(src[0].charAt(i));
			}
		}
		return sbr.toString();
	}
	
	public static String longestCommonNice(String[] src){
		if(null == src)
			return null;
		String prefix = src[0];
		boolean loop = true;
		while(loop){
			loop = false;
			for(int i = 0;i < src.length;i++){
				if(src[i].indexOf(prefix) < 0){
					loop = true;
					prefix = prefix.substring(0, prefix.length() -1);
				}
			}
		}
		return prefix;
	}
}
