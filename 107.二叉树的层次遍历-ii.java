import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 和102 二叉树的层序遍历一样，最后反转数组
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(! q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            res.add(tmp);
        }
        
        // int i = 0, j = res.size() -1;
        // for(; i < j; i++, j--){
        //     List<Integer> tmp = res.get(i);
        //     res.set(i, res.get(j));
        //     res.set(j, tmp);
        // }
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

