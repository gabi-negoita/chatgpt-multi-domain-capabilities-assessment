package ro.ugal.master.problems;

import java.util.ArrayList;
import java.util.List;

/*
 Resolve the following coding problem using the Java language.
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

 A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.




 Example 1:

 Input: digits = "23"
 Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 Example 2:

 Input: digits = ""
 Output: []
 Example 3:

 Input: digits = "2"
 Output: ["a","b","c"]


 Constraints:

 0 <= digits.length <= 4
 digits[i] is a digit in the range ['2', '9'].
*/

public class LetterCombinationsOfAPhoneNumber {

    private static final String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String lettersForDigit = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < lettersForDigit.length(); i++) {
            sb.append(lettersForDigit.charAt(i));
            backtrack(digits, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
