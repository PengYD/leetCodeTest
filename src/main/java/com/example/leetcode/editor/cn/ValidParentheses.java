//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4468 👎 0


package com.example.leetcode.editor.cn;

import java.util.*;

import static javax.swing.UIManager.put;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("{}[([])]{}"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {


            Map<Character, Character> mp = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};

            Deque<Character> st = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (!mp.containsKey(c)) { // c 是左括号
                    st.push(c);
                    // 入栈
                } else if (st.isEmpty() || st.pop() != mp.get(c)) { // c 是右括号
                    return false; // 没有左括号，或者左括号类型不对
                }
            }
            return st.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}