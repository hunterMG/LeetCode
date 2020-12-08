import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    // 1. DFS 递归
    // List<List<Integer>> res = new ArrayList<>();
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     if(root == null){
    //         return res;
    //     }

    //     dfs(root, 0);
    //     return res;
    // }
    // public void dfs(TreeNode node, int level ){
    //     if(level == res.size()){
    //         res.add(new ArrayList<Integer>());
    //     }
    //     List<Integer> arr = res.get(level);
    //     arr.add(node.val);
    //     if(node.left != null){
    //         dfs(node.left, level+1);
    //     }
    //     if(node.right != null){
    //         dfs(node.right, level+1);
    //     }
    // }

    // 2. BFS 队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(! q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> newLevel = new ArrayList<>();
            for(int i = 0; i<size; i ++){
                TreeNode tmp = q.poll();
                newLevel.add(tmp.val);
                if(tmp.left != null){
                    q.offer(tmp.left);
                }
                if(tmp.right != null){
                    q.offer(tmp.right);
                }
            }
            res.add(newLevel);
        }
        return res;
    }

}
// @lc code=end

