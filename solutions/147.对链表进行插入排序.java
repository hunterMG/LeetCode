import java.util.List;

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1. 每次新节点从已排序链表的head开始，寻找插入位置
    // 时间：O(n^2) 空间：O(1)
    public ListNode insertionSortList_0(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head, cur = head.next, nex = null;
        head.next = null;
        while(cur != null){
            nex = cur.next;//保存下一个节点
            cur.next = null;// 切断与后续节点的链接
            ListNode p = newHead;
            if(cur.val < p.val){// 小于头节点
                newHead = cur;
                cur.next = p;
                cur = nex;
                continue;
            }
            while(p != null){
                if(p.next == null){
                    p.next = cur;
                    break;
                }
                if(p.val <= cur.val && cur.val < p.next.val){
                    cur.next = p.next;
                    p.next = cur;
                    break;
                }
                p = p.next;
            }
            cur = nex;
        }
        return newHead;
    }
    // 2. 对1的改进：在head前面添加dummyHead节点，便于插入到head前面
    public ListNode insertionSortList_1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        ListNode cur = head.next, nex = null;
        head.next = null;
        while(cur != null){
            nex = cur.next;//保存下一个节点
            cur.next = null;// 切断与后续节点的链接
            ListNode p = dummyHead;
            while(p != null){
                if(p.next == null){
                    p.next = cur;
                    break;
                }
                if(p.val <= cur.val && cur.val < p.next.val){
                    cur.next = p.next;
                    p.next = cur;
                    break;
                }
                p = p.next;
            }
            cur = nex;
        }
        return dummyHead.next;
    }
    //3. 官方解法：一直向后看直到遇到需要排序的才开始排序，相比1，2:
    // 比如在 [1,2,3, 5,0,9]，在前3个元素已排好序的情况下，解法1、2还是会从头开始找5的插入位置，而该解法直接跳过了。
    // 时间：O(n^2) 空间：O(1)
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode lastSorted = head, cur = head.next;
        while(cur != null){
            if(lastSorted.val <= cur.val){// cur 小于排好序的最后一个（即它的上一个节点）
                lastSorted = cur;         // 此时无需插入，直接下一个
                cur = cur.next;
            }else{// 需要从头开始找插入位置
                ListNode pre = dummyhead;
                while(pre.next.val <= cur.val){
                    pre = pre.next;
                }
                //pre的下一个节点比他大，插入pre后面
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = lastSorted.next;
            }
        }
        return dummyhead.next;
    }
}
// @lc code=end

