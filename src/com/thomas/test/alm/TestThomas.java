package com.thomas.test.alm;

import java.io.IOException;
import java.util.Date;

public class TestThomas {
	public static void main(String[] args) {
		// System.out.println(0.2+0.4);
		// System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 +
		// 0.1);
		// System.out.println(-1 >> 3);
		// System.out.println(Integer.toBinaryString(-1 >> 1));
		// for(char charA : "a".toCharArray()){
		// System.out.println(Integer.toBinaryString(charA)+"|"+Integer.toHexString(charA));
		// }
		// byte b = (byte)0xff;
		// if(b == 0xff)
		// System.out.println("good");
		// System.out.println((short)b);
		// int a = 0x83;
		// System.out.println((long)a);
		// int a = 10000;
		// System.out.println(a+'a');
		//System.out.println(Long.toBinaryString(-1L ^ -1L << 14L));
//		System.out.println(Long.toBinaryString(-1L));
//		System.out.println(Long.toBinaryString(-1L ^ -1L << 10L));
//		long tm = System.currentTimeMillis();
//		System.out.println(tm+ " | "+ Long.toBinaryString(tm));
//		long time1 = tm  << 14L;
//		System.out.println(time1+" | "+Long.toBinaryString(time1));
		try {
			int a= System.in.read();
			System.out.println(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
