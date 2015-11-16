package com.thomas.test.leecode.easy;

/**
 * Implement strStr(). Returns the index of the first occurrence of needle in
 * haystack, or -1 if needle is not part of haystack. Subscribe to see which
 * companies asked this question
 * 
 * @author thomas
 * @time :2015年11月12日下午6:28:08
 */
public class N28ImplementstrStr {
	//暴力解决不好，需要看kMP和Boyer-Moore
	//如下为KMP
	//最好的是Sunday Algorithm > BM > KMP
	public String strStr(String haystack, String needle) {
	    //KMP algorithms
	    if(needle.equals("")) return haystack;
	    if(haystack.equals("")) return null;
	    char[] arr = needle.toCharArray();
	    int[] next = makeNext(arr);

	    for(int i = 0, j = 0, end = haystack.length(); i < end;){
	        if(j == -1 || haystack.charAt(i) == arr[j]){
	            j++;
	            i++;
	            if(j == arr.length) return haystack.substring(i - arr.length);
	        }
	        if(i < end && haystack.charAt(i) != arr[j]) j = next[j];
	    }
	    return null;
	}

	private int[] makeNext(char[] arr){
	    int len = arr.length;
	    int[] next = new int[len];

	    next[0] = -1;
	    for(int i = 0, j = -1; i + 1 < len;){
	        if(j == -1 || arr[i] == arr[j]){
	            next[i+1] = j+1;
	            if(arr[i+1] == arr[j+1]) next[i+1] = next[j+1];
	            i++;
	            j++;
	        }
	        if(arr[i] != arr[j]) j = next[j];
	    }

	    return next;
	}
	
	//BM
	public String strStrBM(String haystack, String needle) 
	{
	    if(haystack== null) return null;
	    if(needle==null || needle.length()==0) return haystack;
	    if(needle.length()>haystack.length()) return null;

	    int pat_length = needle.length();
	    int right[] = new int[256];

	    for(int i=0;i<256;i++)
	      right[i] =-1;
	    for(int i=0;i<pat_length;i++)
	      right[needle.charAt(i)] =i;

	    int rtn = search(right,haystack,needle);
	    if(rtn == haystack.length()) return null;
	    else 
	        return haystack.substring(rtn);
	}
	public int search(int[] right, String haystack,String needle)
	{
	    int M = haystack.length();
	    int N = needle.length();
	    int i,j;
	    int skip =0;
	    for(i=0; i<=M-N; i+=skip)
	    {
	        skip =0;
	        for(j=N-1;j>=0;j--)
	        {
	            if(needle.charAt(j)!=haystack.charAt(i+j))
	            {
	                skip = j-right[haystack.charAt(j+i)];
	                if(skip<=0) skip=1;
	                break;
	            }
	        }
	        if(skip ==0) return i;
	    }
	    return M;

	}
}
