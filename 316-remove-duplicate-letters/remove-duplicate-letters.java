class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];

        for(char ch : s.toCharArray()){
            count[ch - 'a']--;
            if(seen[ch - 'a']){
                continue;
            }
            while (!stack.empty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
                char removed = stack.pop();
                seen[removed - 'a'] = false;
            }
            stack.push(ch);
            seen[ch - 'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        for(char c : stack){
            res.append(c);
        }
        return new String(res);
    }
}