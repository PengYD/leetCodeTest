//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7130 👎 0


package com.example.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        new MedianOfTwoSortedArrays().new Solution().findMedianSortedArrays(null, null);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

//            nums1 = new int[]{1,2};
//            nums2 = new int[]{3,4};
            int i1 = 0;
            int i2 = 0;
            int j = 0;
            int[] nums = new int[2001];

            // 合并数组，保证顺序, 直至其中一个数组遍历结束
            while (i1 < nums1.length && i2 < nums2.length) {
                int i = nums1[i1] > nums2[i2] ? (nums[j++] = nums2[i2++]) : (nums[j++] = nums1[i1++]);
            }
            while (i1< nums1.length) {
                nums[j++] = nums1[i1++];
            }
            while (i2< nums2.length) {
                nums[j++] = nums2[i2++];
            }

            double ans = 0;
            int last = j - 1;
            if (last % 2 == 0) {
                ans = nums[last / 2];
            }else {
                ans = (double) (nums[last/2] + nums[last/2 + 1]) / 2;

            }
            return ans;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}