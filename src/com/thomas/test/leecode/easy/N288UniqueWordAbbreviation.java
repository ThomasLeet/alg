package com.thomas.test.leecode.easy;

/**
 * 唯一单词缩写
 * 假设您有一个词典和词,找到其缩写是否在字典里是独一无二的。
 * 一个单词的缩写是独一无二的如果没有其他词词典有相同的缩写。
 * Ex：
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true 
 * 
 * 缩写规则：
 * 第一个字母+中间字母数量+最后一个字母
 * a) it                      --> it    (no abbreviation)
 *      1
 * b) d|o|g                   --> d1g
 *               1    1  1
 *      1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 * @author thomas
 * @time :2015年11月16日上午10:52:43
 */
public class N288UniqueWordAbbreviation {

}
