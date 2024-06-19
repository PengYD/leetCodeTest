//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2839 👎 0


package com.example.leetcode.editor.cn;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("369");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String letterMap[] = { " ", //0
                "", //1
                "abc", //2
                "def", //3
                "ghi", //4
                "jkl", //5
                "mno", //6
                "pqrs", //7
                "tuv", //8
                "wxyz" //9
        };
        public List<String> letterCombinations(String digits) {
            List<String> rep = new ArrayList<>();
            if (digits == null || digits.length() == 0) {
                return rep;
            }

            StringBuilder s = new StringBuilder();
            test1(rep, digits, "", 0);
            return rep;
        }

        private void test1(List<String> rep, String digits, String s, int i) {

            if (i == digits.length()) {
                rep.add(s);
                return;
            }
            String s1 = letterMap[digits.charAt(i) - '0'];

            for (int j = 0; j < s1.length(); j++) {
                test1(rep, digits, s + s1.charAt(j), i + 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}