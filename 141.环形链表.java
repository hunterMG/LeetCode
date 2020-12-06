import java.util.HashSet;
/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // 1. 快慢指针
    // public boolean hasCycle(ListNode head) {
    //     ListNode slow = head, fast = head;
    //     while(fast != null && fast.next != null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //         if(slow == fast){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    //2. 哈希表
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while(p != null){
            if(set.contains(p)){
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }

}
// @lc code=end

