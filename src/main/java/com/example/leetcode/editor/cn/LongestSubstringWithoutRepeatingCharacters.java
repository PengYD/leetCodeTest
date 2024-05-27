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

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String a = " ";
        new LongestSubstringWithoutRepeatingCharacters().new Solution().lengthOfLongestSubstring(a);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            // 字符下标
            int index = 0;
            // 重复元素最后出现位置
            int flag = 0;
            // 长度
            int length = 0;
            // 中间产物
            int result = 0;
            while (index < s.length()) {

                // 由于flag 永远小于 i  所以pos不会等于-1，不重复的情况 pos = index，重复的情况pos等于上次出现本元素的位置（小于index）
                int pos = s.indexOf(s.charAt(index), flag);

                // 判断重复  pos表示flag到末尾
                if (pos < index) {

                    if (length > result) {
                        result = length;
                    }

                    length = index - pos - 1;
                    flag = pos + 1;
                }
                length++;
                index++;
            }

            if (result < length) {
                result = length;
            }

            System.out.println(result);
            return result;






//            // 当前坐标
//            int i = 0;
//            // 扫描起点
//            int flag = 0;
//            // 长度
//            int length = 0;
//            // 中间产物，不重复字符长度。
//            int result = 0;
//            while (i < s.length()) {
//                int pos = s.indexOf(s.charAt(i), flag);
//                if (pos < i) {
//                    // 出现重复元素
//                    if (length > result) {
//                        // 是否大于上次不重复字符串的长度
//                        result = length;
//                    }
//                    // 不重复字符串长度已超过剩余字符长度 直接返回。
//                    if (result >= s.length() - pos - 1) {
//                        return result;
//                    }
//                    length = i - pos - 1;
//                    flag = pos + 1;
//                }
//                length++;
//                i++;
//            }
//            return length;



//            Map<Character, Integer> map = new HashMap<>();
//
//            List<String> list = new ArrayList<>();
//
//            String str = "";
//
//            int max = 0;
//
//            char[] array = s.toCharArray();
//            for (int i = 0; i < array.length; i++) {
//                if (str.contains(array[i] + "")) {
//                    // 已有重复, 查询重复字符最后出现位置，并用本次位置替换。
//                    Integer index = map.get(array[i]);
//                    int size = str.length();
//                    str = s.substring(index + 1, i);
//                    // 计算本次出现重复时 字符长度 与最长字符长度比较
//                    if (size > max) {
//                        max = size;
//                    }
//                }
//                str = str + array[i];
//                // 记录本次字符 和 所在位置
//                map.put(array[i], i);
//            }
//            if (str.length() > max) {
//                max = str.length();
//            }
//
//            System.out.println(max);
//            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}