/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        ListNode p = head, q = head;

        while(n!=0){
            p = p.next;
            n--;
        }
        if(p == null){
            return head.next;
        }
        while(p.next != null ){
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return head;
    }
}
// @lc code=end

