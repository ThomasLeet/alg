1.找规律
（从0或者1低的数开始找规律）
2.

循环：
注意边界

技巧：
1.有两个数(a ,b)，给第三个数(z)判断它是不是同时大于或者小于这两个数时，可以使用 (z-a)*(z-b) > 0的方法
2.位操作N169找出
3.链表删除N237，单链表逆序N206
4.取int的指定位的值 例如取百位：(n/100)%10
5.int去掉指定位数 （n/10去掉个位, n/100去掉个位和十位）
6.在用int型赋默认值来判断是否赋过值时最好使用integer的null，因为int默认值可能和有意义的值冲突。
7.在多个循环和多个指针的时候记住每个指针代表的意义方便记忆不易出错 （118）
8.不管是什么结构中，无论是寻找某值或者比较某值，一定在过程中需要存储过程变量（270）
9.问题变换时可以在操作开始就变换，也可以操作结束时变换。
10. N！表示n的阶乘 1*2*3*4*5...*n
11.翻转int型时，使用另外一个int做翻转，不要在int自身否则有溢出风险。（9）
12 两个链表的长度如果需要对齐可以话可以互相循环扫，这样第二遍就对齐了。（160）
13.int数组判断是否有重复
http://blog.csdn.net/yahohi/article/details/7900955
14.当题目有多个条件限制是，先找出所有条件里能过滤掉最多内容的条件，优先使用这些条件！！！（219）
15.java中char的前256和ascII码相同，char是两个字节是unicode字符集作为编码能够保存中文。（205）
16.0-9的数字(不是ascII码)转char通过方法(char)('0'+9) ，char转int的0-9通过Character.getNumberValue('9')(67)
17.二进制(src1]="111",src2="101")的加法中每个位都转换为int值然后异或，
   每个位中的进位是通过两个相加的相关位和上一位的进位相加如果大于2就为有进位（67）


常犯错误
1.多链表操作时不要忘记移动当前节点。（21）
2.考虑结束的收尾工作 （21）
3.在数组、链表等结构中，想把特定子数组向后移位时注意顺序（198）
--------------------------------
算法：
1.摩尔投票算法（169）

斐波那契：(70)
1.此步骤可以通过前两个步骤推导而来
2.且连两个部分不重复，不冲突

Floyd判圈算法


需进一步研究：
1.BM算法
http://segmentfault.com/a/1190000002619088
2. Arrays.sort
3.字符串中子串查找，Boyer-Moore KMP
http://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
4.素数的问题，一个是是否是素数（204）

--------
参考：
https://leetcode.com/problemset/algorithms/
http://lcoj.tk/problems/Shortest-Word-Distance/ 上锁的题这里有
http://www.jiuzhang.com/solutions/search/?question=Contains+Duplicate 答案

其他刷题网站：
programming pearls

术语：
bst二叉排序树 Binary Sort Tree
http://blog.csdn.net/stpeace/article/details/9067029