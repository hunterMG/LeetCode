import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(m.containsKey(target-nums[i])){
                return new int[]{i, m.get(target-nums[i])};
            }
            else{
                m.put(nums[i], i);
            }
        }

        return new int[2];
    }
}
// @lc code=end

