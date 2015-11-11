package com.thomas.test.alm;

public class BackTrack {
	/**
	 * 
	int a[n],i;
	初始化数组a[];
	i = 1;
	while (i>0(有路可走)   and  (未达到目标))  // 还未回溯到头
	{
	    if(i > n)                                              // 搜索到叶结点
	    {   
	          搜索到一个解，输出；
	    }
	    else                                                   // 处理第i个元素
	    { 
	          a[i]第一个可能的值；
	          while(a[i]在不满足约束条件且在搜索空间内)
	          {
	              a[i]下一个可能的值；
	          }
	          if(a[i]在搜索空间内)
	         {
	              标识占用的资源；
	              i = i+1;                              // 扩展下一个结点
	         }
	         else 
	        {
	              清理所占的状态空间；            // 回溯
	              i = i –1; 
	         }
	}
	 */
}
