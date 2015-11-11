package com.thomas.test.leecode.easy;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * @author thomas
 * @time :2015年11月10日上午10:02:56
 */
public class N190ReverseBits {
	
	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
	}
	
	//自己的nice
	public static int reverseBits(int src){
		if(src == 0)
			return 0;
		System.out.println(Integer.toBinaryString(src));
		int result = 0;
		int digits = 0;
		while(src > 0){
			result = src % 2 > 0 ? result + 1 << 1 : result << 1;
			src = src >>> 1;
			digits++;
		}
		result = result << 32 - digits;
		System.out.println(Integer.toBinaryString(result >>> 1));
		return result >>> 1;
	}
}
