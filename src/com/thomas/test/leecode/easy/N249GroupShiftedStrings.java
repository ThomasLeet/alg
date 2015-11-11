package com.thomas.test.leecode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://sbzhouhao.net/LeetCode/LeetCode-Group-Shifted-Strings.html
 * @author thomas
 * @time :2015年11月10日下午5:34:46
 */
public class N249GroupShiftedStrings {
	public static void main(String[] args) {
	}

	// 不是自己写的
	public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strings) {
			int offset = str.charAt(0) - 'a';
			String key = "";
			for (int i = 0; i < str.length(); i++) {
				char c = (char) (str.charAt(i) - offset);
				if (c < 'a') {
					c += 26;
				}
				key += c;
			}
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<String>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}
		for (String key : map.keySet()) {
			List<String> list = map.get(key);
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}
}
