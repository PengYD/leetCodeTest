//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3991 👎 0


package com.example.leetcode.editor.cn;

public class ReverseInteger {
    public static void main(String[] args) {
        new ReverseInteger().new Solution().reverse(99);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {


            int res = 0;
            while(x!=0) {
                //每次取末尾数字
                int tmp = x%10;
                //判断是否 大于 最大32位整数
                if (res>214748364 || (res==214748364 && tmp>7)) {
                    return 0;
                }
                //判断是否 小于 最小32位整数
                if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                    return 0;
                }
                res = res*10 + tmp;
                x /= 10;
            }
            return res;


//            if ( x == 0) {
//                return 0;
//            }
//
//            String a = x + "";
//            boolean flag = false;
//
//            if (a.charAt(0)  ==  '-') {
//                a = a.substring(1, a.length());
//                flag = true;
//            }
//
//            StringBuilder s = new StringBuilder();
//            for (int i = a.length() - 1; i >= 0; i--) {
//                char c = a.charAt(i);
//                if (c == '0' && s.length() == 0) {
//                    continue;
//                }
//                s.append(c);
//            }
//            String str = s.toString();
//            if (flag) {
//                str = "-" + str;
//            }
//            if (Long.valueOf(str) > Integer.MAX_VALUE || Long.valueOf(str) < Integer.MIN_VALUE) {
//                return 0;
//            }
//
//            return Integer.valueOf(str);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}