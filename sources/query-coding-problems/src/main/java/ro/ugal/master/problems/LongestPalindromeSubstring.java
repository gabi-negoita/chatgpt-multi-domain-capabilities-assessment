package ro.ugal.master.problems;

/*
 Resolve the following coding problem using the Java language.
 Given a string s, return the longest
 palindromic

 substring
 in s.



 Example 1:

 Input: s = "babad"
 Output: "bab"
 Explanation: "aba" is also a valid answer.
 Example 2:

 Input: s = "cbbd"
 Output: "bb"


 Constraints:

 1 <= s.length <= 1000
 s consist of only digits and English letters.
*/

public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int center = 0; center < s.length(); center++) {
            int length1 = expandAroundCenter(s, center, center);
            int length2 = expandAroundCenter(s, center, center + 1);
            int length = Math.max(length1, length2);

            if (length > end - start + 1) {
                start = center - (length - 1) / 2;
                end = center + length / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
