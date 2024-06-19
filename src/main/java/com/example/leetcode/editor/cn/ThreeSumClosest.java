//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1628 👎 0


package com.example.leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[] {1,1,1,1}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {

            if (nums.length < 3) {
                return 0;
            }
            Arrays.sort(nums);

            int min = Integer.MAX_VALUE;
            int j = 0;

            int i = 0;

            while (i < nums.length){

                int l = i + 1;
                int r = nums.length - 1;

                if (i > 0 && nums[i] == nums[i-1]) {
                    i++;
                    continue;
                }

                while (l < r) {

                    int n = nums[i] + nums[l] + nums[r];

                    // 到目标点的距离
                    int i1 = Math.abs(target - n);

                    if (i1 < min) {
                        min = i1;
                        j = n;
                    }

                    if (n == target) {
                      return n;
                    }

                    if (n > target) {
                        r--;
                    }

                    if (n < target) {
                        l++;
                    }
                }

                i++;
            }

            return j;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}