import java.util.ArrayList;
import java.util.List;

class Solution {
    // Using an array instead of a string for clarity
    private static final String[] digitToLetters = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        return padRet("", digits);
    }

    private static ArrayList<String> padRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';  // Convert char digit to int
        String letters = digitToLetters[digit];

        ArrayList<String> list = new ArrayList<>();
        // Instead of fixed calculations, iterate over the characters in the string
        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            list.addAll(padRet(p + ch, up.substring(1)));
        }
        return list;
    }
}