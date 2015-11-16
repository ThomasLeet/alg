package com.thomas.test.leecode.easy;
/**
 * 你和你的朋友玩游戏下面的公牛和母牛:
 * 你写下一个号码并让你的朋友猜号码是什么。
 * 每一次你的朋友猜,你提供一个提示,
 * 显示有多少位数的数字和位置都匹配上你的秘密了(称为“公牛”),
 * 有多少数字匹配密码但定位错误的位置(称为“母牛”)。
 * 你的朋友将使用连续的猜测和提示,最终推导出密码。
 * For example:
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * 
 * Write a function to return a hint according to the secret number and friend's guess, 
 * use A to indicate the bulls and B to indicate the cows.
 * In the above example, your function should return "1A3B".
 * Please note that both secret number and friend's guess may contain duplicate digits, 
 * 
 * for example:
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, 
 * the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, 
 * and their lengths are always equal.
 * @author thomas
 * @time :2015年11月12日下午3:21:46
 */
public class N299BullsAndCows {
	
	public static void main(String[] args) {
		System.out.println(bc("2173553","0125335"));
	}
	
	//自己解法，可以优化到int数组大小为10
	public static String bc(String secret, String guess){
 		int[] digitIndex = new int[20];
 		int length = secret.length();
 		int bull = 0;
 		int cow = 0;
 		for(int i=0; i < length ;i++){
 			if(secret.charAt(i) == guess.charAt(i)){
 				bull++;
 			}else{
 				int digitSrc1 = Character.getNumericValue(secret.charAt(i));
 				int digitSrc2 = Character.getNumericValue(guess.charAt(i));
 				if(digitIndex[digitSrc1] <= 0)
 					digitIndex[digitSrc1] = 1;
 				if(digitIndex[digitSrc1+10] > 0){
 					cow++;
 					System.err.println("digitSrc1 : "+digitSrc1);
 					digitIndex[digitSrc1+10] = -1;
 					digitIndex[digitSrc1] = -1;
 				}
 				if(digitIndex[digitSrc2 +10] <= 0)
 					digitIndex[digitSrc2+ 10] = 1;
 				if(digitIndex[digitSrc2] > 0){
 					cow++;
 					System.err.println("digitSrc2 : "+digitSrc2);
 					digitIndex[digitSrc2] = -1;
 					digitIndex[digitSrc2+10] = -1;
 				}
 			}
 		}
 		return bull+"B"+cow+"C";
	}
}
