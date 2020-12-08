import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    // 暴力：O(n^2)
    public int lengthOfLongestSubstring0(String s) {
        int maxL = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0; i < s.length(); i++){           
            for(int right = i; right < s.length(); right ++){
                if(set.contains(s.charAt(right))){
                    break;
                }else{
                    set.add(s.charAt(right));
                }
            }
            maxL = Math.max(maxL, set.size());
            set.clear();
        }
        return maxL;
    }
    // 1. HashMap
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxL = 0, start = 0;
        for(int i=0; i < s.length(); i ++){// i是子串最后一个位置
            if(map.containsKey(s.charAt(i))){
                start = Math.max(start, map.get(s.charAt(i)) + 1);
                // 取max（start，）是因为重复数字的索引可能比start小
            }
            // else // 不能用else，如用else只有在不重复的时候计算maxL，而如果重复的是start之前的还是应该计算（如"tmmzuxt"最后一个 t ）
            {
                maxL = Math.max(maxL, i - start + 1);// 包含i的最长不重复子串
                map.put(s.charAt(i), i);
            }
        }
        return maxL;
    }
    // 2. 双指针 set
    /**
     * 如果end元素在set中，就删除set中的start元素，右移start指针，直到不重复
     * 如果end元素不在set中，将其加入set，计算最大长度 （end-start+1）,右移end指针
     * 时间复杂度 O(n), 空间复杂度O
     */
    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        int start = 0, end = 0, maxL = 0;
        HashSet<Character> set = new HashSet<>();
        while(end < len){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start ++;
            }else{
                set.add(s.charAt(end));
                maxL = Math.max(maxL, end - start + 1);
                end ++;
            }
        }
        return maxL;
    }
}
// @lc code=end

