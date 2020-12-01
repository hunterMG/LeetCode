/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int curSum=0, carry = 0;
        ListNode p =l1, q=l2, res = new ListNode();
        ListNode s = res;
        while(p != null | q!=null | carry!=0){
            if(p!=null){
                curSum += p.val;
                p = p.next;
            }
            if(q!=null){
                curSum += q.val;
                q = q.next;
            }
            curSum += carry;
            ListNode tmp = new ListNode(curSum % 10);
            carry = curSum / 10;
            s.next = tmp;
            s = s.next;
            curSum = 0;
        }

        return res.next;
    }
}
// @lc code=end

