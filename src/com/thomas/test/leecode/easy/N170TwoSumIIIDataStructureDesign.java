package com.thomas.test.leecode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find. add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the
 * value.
 * 
 * For example, add(1); add(3); add(5); find(4) -> true find(7) -> false
 * 
 * @author thomas
 * @time :2015年11月12日下午2:32:01
 */
public class N170TwoSumIIIDataStructureDesign {

	//不是自己写的。
	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public void add(int number) {
		map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
	}

	public boolean find(int value) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int i = entry.getKey();
			int j = value - i;
			if ((i == j && entry.getValue() > 1)
					|| (i != j && map.containsKey(j))) {
				return true;
			}
		}
		return false;
	}
}
