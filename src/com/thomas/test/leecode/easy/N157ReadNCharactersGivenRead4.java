package com.thomas.test.leecode.easy;


/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, 
 * it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, 
 * implement the function int read(char *buf, int n) that readsn characters from the file.
 * @author thomas
 * @time :2015年11月10日上午10:43:51
 */
public class N157ReadNCharactersGivenRead4 {
	public static int read(char[] buf , int n){
		int count = 0;
		char[] tem = new char[4];
		int readSize = 0;
		int cursor = 0;
		while((readSize = read4(tem)) > 0){
			count += readSize;
			for(int i = 0 ;readSize >= 0; i++,readSize--){
				buf[cursor++ + i] = tem[readSize-1];
			}
		}
		return count;
	}
	
	public static int read4(char[] buf){
		return 0;
	} 
}
