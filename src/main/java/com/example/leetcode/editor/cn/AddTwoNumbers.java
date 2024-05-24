//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 10599 👎 0


package com.example.leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] l3 = new int[]{2, 4, 3};
        int[] l4 = new int[]{5, 6, 4};

        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        ListNode pre ;

        pre = l1;
        for (int i = 0; i < l3.length; i++) {
            pre.val = l3[i];
            if (i != l3.length - 1) {
                pre = (pre.next = new ListNode());
            }
        }

        pre = l2;
        for (int i = 0; i < l4.length; i++) {
            pre.val = l4[i];
            if (i != l4.length - 1) {
                pre = (pre.next = new ListNode());
            }
        }

      new AddTwoNumbers().new Solution().addTwoNumbers(l1, l2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int sum = x + y + carry;

                // 是否进位
                carry = sum / 10;
                // 取余数，代表当前位数的值。
                sum = sum % 10;
                // 将结果放入 pre的后一节点，每次进位
                cur.next = new ListNode(sum);

                cur = cur.next;
                if (l1 != null)
                    l1 = l1.next;
                if (l2 != null)
                    l2 = l2.next;
            }
            // 判断最后一次运算是否发生进位
            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}