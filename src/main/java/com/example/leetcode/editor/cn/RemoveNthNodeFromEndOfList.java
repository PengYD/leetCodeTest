//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2884 👎 0


package com.example.leetcode.editor.cn;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();

        int[] l3 = new int[]{1,2,3,4,5};

        ListNode node = new ListNode();

        ListNode pre ;

        pre = node;

        for (int i = 0; i < l3.length; i++) {
            pre.val = l3[i];
            if (i != l3.length - 1) {
                pre = (pre.next = new ListNode());
            }
        }


        solution.removeNthFromEnd(node, 2);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode start = pre, end = pre;
            while (n != 0) {
                start = start.next;
                n--;
            }
            while (start.next != null) {
                start = start.next;
                end = end.next;
            }
            end.next = end.next.next;
            return pre.next;

//            ListNode per = new ListNode();
//            ListNode end = new ListNode();
//            end.next = head;
//            per.next = head;
//            // {1,2,3,4,5} 2
//            while (n > 0) {
//                per = per.next;
//                n--;
//            }
//
//            if (per == null) {
//                return null;
//            }
//
//            while (per.next != null) {
//                per = per.next;
//                end = end.next;
//            }
//
//            end.next = end.next.next;
//
//            return per;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}