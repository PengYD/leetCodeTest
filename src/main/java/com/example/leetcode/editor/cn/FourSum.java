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
        solution.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();

            // 长度不够 直接退出
            if (nums.length < 4) {
                return res;
            }
            Arrays.sort(nums);

            // 固定第一个数，
            for (int i = 0; i < nums.length; i++) {

                // 去掉重复的
                while (i < nums.length && i > 0 && nums[i] == nums[i - 1]) {
                    i = i +1;
                }

                // j 初始为i后一个元素，并且i后的元素少于三个 退出。 i+j 大于目标值退出。
                int j = i + 1;
                if ( i > nums.length - 3 ) {
                    break;
                }
                for (; j < nums.length - 2; j++) {

                    while (j < nums.length - 2 && j - 1 != i  && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    int l = j + 1;
                    int r = nums.length - 1;

                    while (l < r) {

                        while ( nums.length - 2 > r && nums[r] == nums[r + 1] && r - 1 > l) {
                            r--;
                        }
                        while (l + 1 < r && nums[l] == nums[l - 1] && l-1 != j) {
                            l++;
                        }

                        long n = 0L + nums[i] + nums[j] + nums[l] + nums[r];
                        if (n == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                            do {
                                r--;
                                l++;
                            } while (nums[l] == nums[l - 1] && nums[r] == nums[r + 1] &&  l < r );

                            continue;
                        }

                        if (n > target) {
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