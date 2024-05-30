//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//                       3   3*2 -2
// 1   5   9               2 或者 4
// 2 4 6 8 10
// 1   5   9               4*2 - 2
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N    6-6  6-0    0  6  12
//A   L S  I G    6-1  6-5    1  5  7  11 13
//Y A   H R       6-2  6-4    2  4  8  10
//P     I         6-3  6-3    3  9  15
//                   4    4*2 -2
// 1   7   13             6 或者 4
// 4 2 4 2 4              2 或者 6
// 2 4 2 4 2              4*2 - 2
// 7   13  19
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 2321 👎 0


package com.example.leetcode.editor.cn;

public class ZigzagConversion {
    public static void main(String[] args) {
        new ZigzagConversion().new Solution().convert(null, 0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {

            // 以下情况直接返回
            if (s == null || s.length() < 3 || numRows == 1) {
                return s;
            }
//            s = "PAYPALISHIRING";
//            numRows = 4;
            // 支取前N个元素
            // 第一行为等差数列  N*2 - 2
            // 中间行 为两个交叉的等差数列  N*2 - 2  两个数列相差  （N - 当前行数 ）* 2
            // 末行为等差数列    N*2 - 2
            int i1 = numRows * 2 - 2;
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < numRows; i++) {

                // 间隔
                int m = i1 - i;

                int j = i;

                // 奇偶计数器
                int f = 0;

                while ( j < s.length() && str.length() < s.length()) {
//                    System.out.println(j);
                    if (i == 0 || i == m) {
                        str.append(s.charAt(j));
                        j = j + i1;
                       continue;
                    }

                    if (f%2 == 0) {
                        str.append(s.charAt(j));
                        j = j + m - i;
                    } else {
                        str.append(s.charAt(j));

                        j = j + 2*i;
                    }
                    f++;
                }
            }
            return str.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}