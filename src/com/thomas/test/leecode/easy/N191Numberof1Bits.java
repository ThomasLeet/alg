package com.thomas.test.leecode.easy;

/**
 * 编写一个函数,它接受一个无符号整数并返回它' 1 '的比特数(也称为汉明权重算法)。
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
 * so the function should return 3
 */
public class N191Numberof1Bits {
	
	public static void main(String[] args) {
		System.out.println(hammingCode(7));
	}
	
	/**
	 * hammming code
	 * 参考源代码
	 * @param src
	 * @return
	 */
	public static int hammingCode(int src){
		return Integer.bitCount(src);
	}
	
	public static int oneNumber(int src){
		int result = 0;
		while(src > 0){
			result = result + (src & 1);
			src = src >>> 1;
		}
		return result;
	}
}	
