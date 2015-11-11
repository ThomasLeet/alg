package com.thomas.test.encryption;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * cipher 支持的算法 http://docs.oracle.com/javase/6/docs/technotes/guides/security/
 * StandardNames.html
 */
public class Aes {
	public static String KEY_ALGORITHM = "AES";
	public static String DES_KEY_ALGORITHM = "DES";
	public static String TRANSFORMATION = "AES/ECB/PKCS5Padding";
	public static String DES_TRANSFORMATION = "DES";
	public static byte[] data = new byte[1024*100];//"这是个被加密的字符串".getBytes();
	
	public static void main(String[] args) {
		byte[] data = "123456789012345678901234567890".getBytes();
		System.out.println(data.length);
		byte[] enData = aes(data);
		aesDecipher(enData);
	}
	
	/**
	 * aes des 性能对比 
	 *          aes   des
	 * 数据 1k   753   627
	 * 数据 10k  896   2788
	 * 数据 100k 2515  24934
	 * @param args
	 */
	public static void testPerformance(){
		long startTime = System.currentTimeMillis();
		int loopNumber = 10000;
		for(int i =0 ;i< loopNumber;i++){
			aes(data);
		}
		System.out.println(System.currentTimeMillis()-startTime);
		startTime = System.currentTimeMillis();
		for(int i =0 ;i< loopNumber;i++){
			des();
		}
		System.out.println(System.currentTimeMillis()-startTime);
	}
	 
	public static byte[] aes(byte[] data){
		try {
			// SecretKeySpec对称密钥
			// 此类仅对能表示为一个字节数组并且没有任何与之相关联的钥参数的原始密钥有用，如，DES 或者 Triple DES 密钥。
			byte[] secretKey = new byte[32];//getRawKey("1234567890".getBytes());
			Key key = new SecretKeySpec(secretKey, KEY_ALGORITHM);
			Cipher c = Cipher.getInstance(TRANSFORMATION);
			c.init(Cipher.ENCRYPT_MODE, key);
			return c.doFinal(data);
			//System.out.println(new String(c.doFinal(data)) + ", key content : "+ Arrays.toString(secretKey)+ " , key length : "
				//	+ secretKey.length);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void aesDecipher(byte[] data){
		try {
			byte[] secretKey = new byte[32];
			Key key = new SecretKeySpec(secretKey, KEY_ALGORITHM);
			Cipher c = Cipher.getInstance(TRANSFORMATION);
			c.init(Cipher.DECRYPT_MODE, key);
			System.out.println(new String(c.doFinal(data)));
			//System.out.println(new String(c.doFinal(data)) + ", key content : "+ Arrays.toString(secretKey)+ " , key length : "
				//	+ secretKey.length);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
	}
	
	public static void des(){
		byte[] desSecretKey = new byte[8];// getMd5("1234567890");
		Key key = new SecretKeySpec(desSecretKey, DES_KEY_ALGORITHM);
		Cipher c;
		try {
			c = Cipher.getInstance(DES_TRANSFORMATION);
			c.init(Cipher.ENCRYPT_MODE, key);
			c.doFinal(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] getMd5(String src) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(src.getBytes());
			return md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] getRawKey(byte[] seed) {
		KeyGenerator kgen;
		try {
			// KeyGenerator此类提供（对称）密钥生成器的功能。
			// KeyGenerator 对象可重复使用，也就是说，在生成密钥后，可以重复使用同一个 KeyGenerator
			// 对象来生成更多的密钥。
			// 生成密钥的方式有两种：与算法无关的方式和特定于算法的方式。两者之间的唯一不同是对象的初始化：
			kgen = KeyGenerator.getInstance(KEY_ALGORITHM);
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			sr.setSeed(seed);
			kgen.init(256, sr); // 192 and 256 bits may not be available
			SecretKey skey = kgen.generateKey();
			return skey.getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
