package com.thomas.test.alm;

import java.nio.ByteBuffer;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Aes {

	public static String DEFALUT_ALM = "AES/ECB/PKCS5Padding";//"AES/ECB/NoPadding";
	public static String KEY_ALM = "aes";

	public static void main(String[] args) {
		try {
			byte[] encodeBytes = encode("这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！"
					+ "这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！这个是原始文本！！");
			
//			ByteBuffer bb = ByteBuffer.allocate(8+8+8+4);
//			bb.putLong(12345l).put((byte)'*').putLong(88888l).put((byte)'*').putLong(6666l);
//			byte[] src = new byte[bb.limit()];
//			//System.out.println(bb.limit());
//			bb.rewind();
//			bb.get(src);
//			byte[] encodedByte = encode(new String(src));
//			byte[] decodeByte = decode(encodedByte);
//			ByteBuffer decodeBuffer = ByteBuffer.wrap(decodeByte);
//			System.out.println(decodeBuffer.getLong());
//			System.out.println(decodeBuffer.get());
//			System.out.println(decodeBuffer.getLong());
//			System.out.println(decodeBuffer.get());
//			System.out.println(decodeBuffer.getLong());
			//byte[] encodeBytes = encode("这个是ceshi 23r4vh[0ohnjlnl;这个是ceshi 23r4vh[0ohnjlnl;这个是ceshi 23r4vh[0ohnjlnl;这个是ceshi 23r4vh[0ohnjlnl;这个是ceshi 23r4vh[0ohnjlnl;这个是ceshi 23r4vh[0ohnjlnl;这个是ceshi 23r4vh[0ohnjlnl;这个是ceshi 23r4vh[0ohnjlnl;这个是ceshi 23r4vh[0ohnjlnl;这个是ceshi 23r4vh[0ohnjlnl;");
			System.out.println("after encode:"+encodeBytes.length);
			System.out.println("important :"+new String(encodeBytes));
			System.out.println(new String(decode(encodeBytes)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] encode(String src) throws Exception {
		byte[] keyBytes = new byte[32];
		Cipher c = Cipher.getInstance(DEFALUT_ALM);
		Key key = new SecretKeySpec(keyBytes, KEY_ALM);
		c.init(Cipher.ENCRYPT_MODE, key);
		System.out.println("before encode:"+src.getBytes().length);
		return c.doFinal(src.getBytes());
	}

	public static byte[] decode(byte src[]) throws Exception {
		byte[] keyBytes = new byte[32];
		Cipher c = Cipher.getInstance(DEFALUT_ALM);
		Key key = new SecretKeySpec(keyBytes, KEY_ALM);
		c.init(Cipher.DECRYPT_MODE, key);
		return c.doFinal(src);
	}
}
