//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 3130 👎 0


package com.example.leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"ab", "a"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {

            if (strs.length < 2) {
                return strs[0];
            }

            int minLength = 200;
            for (int i = 0; i < strs.length; i++) {
                minLength = Math.min(minLength, strs[i].length());
            }

            int i = test1(minLength, strs);

            return strs[0].substring(0, i);
        }

        private int test1(int minLength, String[] strs) {
            int i;
            for (i = 0; i < minLength; i++) {

                int a = 0;
                for (int i1 = 0; i1 < strs.length; i1++) {
                    char c = strs[i1].charAt(i);

                    if (i1 * c != a) {

                        return i;
                    }
                    a = a + c;
                }
            }
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}