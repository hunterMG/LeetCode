/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int b = 0;
        for(int i = 0; i< nums.length; i++){
            if(b > 0) b+= nums[i];
            else b = nums[i];

            if(b>maxSum) maxSum = b;
         }
         return maxSum;
    }
}
// @lc code=end

