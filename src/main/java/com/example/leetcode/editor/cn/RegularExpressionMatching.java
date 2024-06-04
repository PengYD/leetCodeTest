//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 20 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// Related Topics 递归 字符串 动态规划 👍 3902 👎 0


package com.example.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("aaaaaaa", "a*"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {

            // S串当前下标位置，刚开始为0
            int index = 0;
            // 下一个状态集合
            // 这里状态用p串的下标表示，代表下一次可以从p的这些下标开始匹配
            Set<Integer> nextState = new HashSet<>();
            // 由于是刚开始匹配，这时候p下一个下标是0
            nextMatch(p, 0, nextState);
            // nextState不为空时，表示还有合法的下一个状态，匹配继续
            while (!nextState.isEmpty()) {
                // 当前状态就是上一次的nextState
                Set<Integer> nowState = nextState;
                // 创建新的nextState
                nextState = new HashSet<>();
                // 测试s[index]和集合里的状态是否有匹配
                for (int state : nowState) {
                    // 如果同时到达s和p串末尾，匹配成功
                    if (state >= p.length() && index >= s.length()) {
                        return true;
                    }
                    // 仅仅p到达末尾还不行
                    else if (state >= p.length()) {
                        continue;
                    }
                    // s和p都未到达末尾
                    else if (index < s.length()) {
                        // 这里是匹配上的情况
                        if (p.charAt(state) == '.' || s.charAt(index) == p.charAt(state)) {
                            // 如果p串的下一个字符是'*'，当前状态可以匹配任意多次，所以下一个状态还是当前
                            if (state + 1 < p.length() && p.charAt(state + 1) == '*') {
                                nextMatch(p, state, nextState);
                            }
                            // 否则，下一个状态就是state+1
                            else {
                                nextMatch(p, state + 1, nextState);
                            }
                        }
                    }
                }
                index++;
            }
            // 此时，nextState为空，代表没有合法的下一个状态了，匹配失败
            return false;
        }

        // p:正则表达式
        // state:下一个状态
        // nextState:下一个状态集合，无重复
        private void nextMatch(String p, int state, Set<Integer> nextState) {
            // 首先加上下一个状态到状态集中
            nextState.add(state);
            // 这里是判断下一个字符是'*'的情况，由于此时匹配次数可以是0，所以state+2也是合法的下一个状态
            if (state + 1 < p.length() && p.charAt(state + 1) == '*') {
                nextMatch(p, state + 2, nextState);
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)
}