package com.thomas.test.leecode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组会议时间间隔组成的开始和结束时间(s1,e1,s2,e2,…)(si < ei),确定一个人是否可以参加所有的会议。
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false. 
 * 
 * @author thomas
 * @time :2015年11月2日上午10:20:11
 */
public class N252MeetingRooms {
	
	public static void main(String[] args) {
		Interval[] src = new Interval[4];
		src[0] = new Interval(0,5);
		src[1] = new Interval(5,10);
		src[2] = new Interval(15,20);
		src[3] = new Interval(10,15);
		System.out.println(canAttendAll(src));
		//int[][] src = new int[][]{{0,30},{5,10},{15,20},{10,15}};
	}
	
	public static boolean canAttendAll(Interval[] interval){
		try {
			Arrays.sort(interval, new InterCompareor());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static class InterCompareor implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			if(null == o1 || null == o2)
				return 0;
			if(o1.start < o2.start && o1.end <= o2.start)
				return -1;
			else if(o1.start > o2.start && o2.end <= o1.start)
				return 1;
			throw new RuntimeException();
		}
		
	}
	
	public static class Interval{
		
		public Interval(int start,int end){
			this.start = start;
			this.end = end;
		}
		public int start;
		public int end;
	}
}
