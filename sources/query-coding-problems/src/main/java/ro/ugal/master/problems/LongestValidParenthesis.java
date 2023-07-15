package ro.ugal.master.problems;

import java.util.Stack;

/*
 Resolve the following coding problem using the Java language.
 Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.



 Example 1:

 Input: s = "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()".
 Example 2:

 Input: s = ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()".
 Example 3:

 Input: s = ""
 Output: 0


 Constraints:

 0 <= s.length <= 3 * 10^4
 s[i] is '(', or ')'.
*/

public class LongestValidParenthesis {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int len = i - stack.peek();
                        maxLen = Math.max(maxLen, len);
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }

}
