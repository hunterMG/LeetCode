/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int new_len = 1;
        int pre = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] != pre){
                nums[new_len] = nums[i];
                new_len ++;
                pre = nums[i];
            }
        }
        return new_len;
    }
}
// @lc code=end

