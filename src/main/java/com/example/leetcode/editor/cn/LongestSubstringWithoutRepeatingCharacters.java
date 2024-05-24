//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// qwaswdfghj
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10155 👎 0


package com.example.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String a = "qwaswdfgh";
        new LongestSubstringWithoutRepeatingCharacters().new Solution().lengthOfLongestSubstring(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            Map<Character, Integer> map = new HashMap<>();
            int n = 0;
            int m = 0;

            int max = 0;

            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (map.containsKey(array[i])) {
                    // 已有重复, 查询重复字符最后出现位置，并用本次位置替换。

                    // 计算本次出现重复时 字符长度 与最长字符长度比较


                } else {
                    // 没有重复 记录本次字符 和 所在位置

                }
                map.put(array[i], i);
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}