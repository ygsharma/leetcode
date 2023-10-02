class Solution {
    public List<String> letterCombinations(String digits) {
        
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno","pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();

        backtrack(digits, letters, 0, "", ans);
        
        return ans;
    }

    public void backtrack(String digits, String[] letters, int idx, String li, List<String> ans) {

        if(idx == digits.length()) {
            if(li.length() == digits.length() && digits.length() > 0) ans.add(li);
            return;
        }

        int num = (int)digits.charAt(idx) - '0';

        for(int i = 0; i < letters[num].length(); i++) {
            li += letters[num].charAt(i);
            backtrack(digits, letters, idx+1, li, ans);
            li = li.substring(0, li.length()-1);
            backtrack(digits, letters, idx+1, li, ans);
        }

        return;
    }
}
