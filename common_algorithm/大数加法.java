// 注意int char 互转的方法，char array和String互转的方法
import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        char[] res = new char[110000];
        int res_ind = 0;
//         StringBuilder sb = new StringBuilder();// 太慢了超时
        int i = s.length()-1, j = t.length()-1, carry = 0, curSum = 0;
        while(i >=0 || j >=0 || carry > 0){
            curSum = carry;
            if(i>=0){
                curSum += s.charAt(i) - '0';
            }
            i--;
            if(j>=0){
                curSum += t.charAt(j) - '0';
            }
            j--;
            res[res_ind++] = (char)(curSum % 10 + '0');
//             sb = new StringBuilder(Integer.toString(curSum%10)).append(sb);
            carry = curSum / 10;
        }
        //反转
        for(i=0, j = res_ind -1; i<j; i++, j--){
            char temp = res[i];
            res[i] = res[j];
            res[j] = temp;
        }
        return String.valueOf(res, 0, res_ind);
//         return sb.toString();
//         BigInteger a = new BigInteger(s), b = new BigInteger(t);
//         return String.valueOf(a.add(b));
    }
}