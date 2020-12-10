import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    // 斐波那契数列，迭代
    public int climbStairs0(int n) {
        int[] fib = new int [n+3];
        fib[1] = 1;
        fib[2] = 2;
        for(int i = 3; i <= n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
    // 优化空间
    public int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        int n1 = 1, n2 = 2, cnt = 2;
        while(cnt++ < n){
            int tmp = n1;
            n1 = n2;
            n2 = n1 + tmp;
        }
        return n2;
    }
    // 递归加备忘录
    HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else if(map.containsKey(n)){
            return map.get(n);
        }
        int res = climbStairs(n-1) + climbStairs(n-2);
        map.put(n, res); 
        return res;
    }

    // 天秀做法：评论1

}
// @lc code=end

