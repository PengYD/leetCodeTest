//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1924 👎 0


package com.example.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        solution.fourSum(new int[]{2,1,0,-1}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();

            // 长度不够 直接退出
            if (nums.length < 4 || nums == null) {
                return res;
            }
            Arrays.sort(nums);

            int length = nums.length;
            // 固定第一个数，
            for (int i = 0; i < nums.length - 3; i++) {

                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // i 可以匹配到的最小结果 大于目标，则i不符合条件。并且后续都没有符合条件的
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                // i 可以匹配到的最大结果 小于目标，则i不符合条件。
                if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }

                for ( int j = i + 1; j < nums.length - 2; j++) {

                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    // i 可以匹配到的最小结果 大于目标，则i不符合条件。并且后续都没有符合条件的
                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    // i 可以匹配到的最大结果 小于目标，则i不符合条件。
                    if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }

                    int l = j + 1;
                    int r = nums.length - 1;

                    while (l < r) {

                        long n = (long) nums[i] + nums[j] + nums[l] + nums[r];
                        if (n == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                            while (l < r && nums[l] == nums[l + 1]) {
                                l++;
                            }
                            l++;
                            while (l < r && nums[r] == nums[r - 1]) {
                                r--;
                            }
                            r--;
                        } else if (n > target) {
                            r--;
                        }else {
                            l++;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}