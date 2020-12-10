

/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    // 1. 暴力
    public int strStr1(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        } 
        int len_hay= haystack.length();
        int len_nee= needle.length();
        for(int i=0; i<=len_hay-len_nee; i++){
            int j=0;
            for(; j<len_nee; j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if(j == len_nee){
                return i;
            }
        }
        return -1;
    }

    // 2. KMP
    // 求前缀表/next数组
    public int[] getNext(String s) {
        int len_s = s.length();
        int[] next = new int[len_s];//原始前缀表，未集体右移或减1
        int j = 0;//前缀末尾位置，也代表i之前(包括i)的子串的最长相等前后缀的长度； i：后缀末尾位置
        next[0] = j;
        for(int i = 1; i < len_s; i++){
            while(j>0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int[] next = getNext(needle);
        int j=0;
        for(int i=0; i<haystack.length(); i++){ 
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return (i - needle.length() +1);
            }
        }
        return -1;
    }
}
// @lc code=end

