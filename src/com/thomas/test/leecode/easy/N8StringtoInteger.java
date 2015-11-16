package com.thomas.test.leecode.easy;

/**
 * 字符串转int
 * 
 * 自己考虑的可能
 * 空 || 非数字
 * 数字是否超范围
 * @author thomas
 * @time :2015年11月16日上午11:21:06
 */
public class N8StringtoInteger {
	
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(string2Int("-21474836450000"));
	}

	public static int string2Int(String src){
		if(null == src || src.length() == 0 ){
			return 0;
		}
		char[] srcs = src.toCharArray();
		int result = 0;
		int maxPrefix = Integer.MAX_VALUE / 10 * 10;
		int maxLastValue = Integer.MAX_VALUE % 10;
		int maxNegativeLast = Integer.MIN_VALUE % 10;
		boolean isNegative = false;
		for(int i = 0 ;i < srcs.length; i++){
			if(i > 0 && (srcs[i] < '0' || srcs[i] > '9')){
				return 0;
			}
			if(i == 0 && srcs[i] == '-'){
				isNegative = true;
				continue;
			}
			result = result * 10;
			if(result > maxPrefix)
				return Integer.MAX_VALUE;
			int currentValue = Character.getNumericValue(srcs[i]);
			if(result == maxPrefix){
				if(!isNegative && currentValue > maxLastValue)
					return Integer.MAX_VALUE;
				if(isNegative && currentValue > maxNegativeLast)
					return Integer.MIN_VALUE;
			}
				result = result + currentValue; 
		}
		return isNegative ? result * -1 : result;
	}
}
