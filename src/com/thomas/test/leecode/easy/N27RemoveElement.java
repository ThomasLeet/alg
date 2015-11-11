package com.thomas.test.leecode.easy;

/**
 * 给定一个数组和一个值,删除所有实例的值,并返回新的长度。 　　 　　
 * 元素的顺序可以改变。数组新长度以外的数组可以不考虑。
 * @author thomas
 * @time :2015年11月4日下午4:05:43
 */
public class N27RemoveElement {
	
	/**
	 * 这个方式不好应该参考，283	Move Zeroes
	 * @param src
	 * @param removedInt
	 * @return
	 */
	public static int newLength(int[] src, int removedInt){
		int cursor = 0;
		for(int i = 0 ; i < src.length;i++){
			if(src[i] != removedInt){
				src[cursor] = src[i];
				cursor++;
			}
		}
		return cursor;
	}
}
