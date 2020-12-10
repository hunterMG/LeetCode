import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    // 栈；遇到数字就入栈，遇到运算符就取出栈顶的两个数字，运算后将结果入栈
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        int a,b, tmp;
        for(int i = 0; i< tokens.length; i++){
            switch(tokens[i]){
                case "+":
                    a = Integer.parseInt(stack.pollFirst());
                    b = Integer.parseInt(stack.pollFirst());
                    tmp = b+a;
                    stack.offerFirst(String.valueOf(tmp));
                    break;
                case "-":
                    a = Integer.parseInt(stack.pollFirst());
                    b = Integer.parseInt(stack.pollFirst());
                    tmp = b-a;
                    stack.offerFirst(String.valueOf(tmp));
                    break;
                case "*":
                    a = Integer.parseInt(stack.pollFirst());
                    b = Integer.parseInt(stack.pollFirst());
                    tmp = b*a;
                    stack.offerFirst(String.valueOf(tmp));
                    break;
                case "/":
                    a = Integer.parseInt(stack.pollFirst());
                    b = Integer.parseInt(stack.pollFirst());
                    tmp = b / a;
                    System.out.println(a);
                    stack.offerFirst(String.valueOf(tmp));
                    break;
                default:
                    stack.addFirst(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pollFirst());
    }
}
// @lc code=end

