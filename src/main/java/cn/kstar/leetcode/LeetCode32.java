package cn.kstar.leetcode;

/**
 * <h6>最长有效括号</h6>
 *
 * <p>给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。</p>
 * <pre><b>Examples:</b>
 * Input: "(()"
 * Output: 2
 * Explanation: 最长有效括号子串为 "()"
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: 最长有效括号子串为 "()()"
 * </pre>
 */
public class LeetCode32 {

    /**
     * <h6>括号匹配法</h6>
     * 
     * <p>括号匹配的题，借助stack来求解。需要定义个start变量来记录合法括号串的起始位置。
     * <br/>遍历字符串，如果遇到左括号，则将当前下标压入栈，如果遇到右括号，且当前栈为空，则将下一个坐标位置记录到start，
     * <br/>如果栈不为空，则将栈顶元素取出，此时若栈为空，则更新结果和i - start + 1中的较大值，否则更新结果和i - 栈顶元素中的较大值。
     * 
     * @param  input
     * @return int
     */
    public int longestValidParentheses(String input) {
        int ret = 0;
        if (input == null || input.length() == 0) {
            return ret;
        }
        // 起始位置
        int start = 0;
        int length = input.length();
        // 定义一个存放左括号的栈
        int[] stack = new int[length];
        // 指向栈顶的指针
        int top = -1;
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == '(') {
                stack[++top] = i;
            } else {
                if (top == -1) {
                    start = i + 1;
                } else {
                    top--;
                    ret = (top == -1) ? max(ret, i - start + 1) : max(ret, i - stack[top]);
                }
            }
        }
        return ret;
    }

    private int max(int x, int y) {
        return x > y ? x : y;
    }
}
