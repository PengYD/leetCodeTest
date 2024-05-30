//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7221 👎 0


package com.example.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        new LongestPalindromicSubstring().new Solution().longestPalindrome("");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {

            int max = 0;
            int minIndex = 0;
            int maxIndex = 0;

            for (int i = 0; i < s.length(); i++) {
                int n = i - 1;
                int m = i + 1;

                // 向右延伸，可能会出长度为偶数的子串  例如  abba
                while (m < s.length() && s.charAt(i) == s.charAt(m)) {
                    m++;
                    i++;
                }

                // 向左延伸，一般用不上
                while (n >= 0 && s.charAt(i) == s.charAt(n)) {
                    n--;
                }

                // 向两边延伸
                while (n >= 0 && m < s.length() && s.charAt(n) == s.charAt(m)) {
                    m++;
                    n--;
                }

                if ((m - n - 1) > max ) {
                    max = m - n - 1;
                    minIndex = n + 1;
                    maxIndex = m ;
                }
            }
            return s.substring(minIndex, maxIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}