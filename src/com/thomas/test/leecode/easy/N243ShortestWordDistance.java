package com.thomas.test.leecode.easy;

/**
 * 给定一个字符串数组，以及两个存在于该数组中得字符串，找出它们在数组中的最短距离；
 * 
 * 给定一个单词列表和两个词word1 word2,返回列表中这两个词之间最短的距离。
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * 
 * 注意：
 * 该数组中得字符串有可能出现多次，比如例子中的makes; 而且可能连续出现
 * @author thomas
 * @time :2015年10月29日上午11:11:53
 */
public class N243ShortestWordDistance {
	
	public static void main(String[] args){
		System.out.println(shortestDis(new String[]{"a","asdf","b","b","a","c","b"},"a","b"));
	}

	public static int shortestDis(String[] src,String word1,String word2){
		if(null == word1 || null == word2)
			return -1;
		int minDis = -1;
		String nextWord = null;
		int preIndex = -1;
		int length = src.length;
		for(int i = 0 ; i < length; i++){
			if(src[i].equals(word1) || src[i].equals(word2)){
				if(null == nextWord || !nextWord.equals(src[i])){
					nextWord = src[i];
					if(preIndex < 0){
						preIndex = i;
					}else{
						int currentDis = i-preIndex;
						if(minDis == -1 || minDis > currentDis){
							minDis = currentDis;
						}
						preIndex = i;
					}
				}else if(null != nextWord && nextWord.equals(src[i])){
					preIndex = i;
				}
			}
		}
		return minDis;
	}
}
