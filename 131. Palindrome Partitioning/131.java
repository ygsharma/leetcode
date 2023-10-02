class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        
        substrings(s, 0, new ArrayList<String>());
        return ans;
    }

    public void substrings(String s, int idx, List<String> li) {

        if(idx == s.length()) {
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i = idx; i < s.length(); i++) {
                          
            if(isPalindrome(s, idx, i)) {
                li.add(s.substring(idx, i+1));
                substrings(s, i+1, li);
                li.remove(li.size()-1);
            }
        }

        return;
    }

    public boolean isPalindrome(String s, int l, int r) {

        while(l < r) 
            if(s.charAt(l++) != s.charAt(r--)) return false;
        

        return true;
    }
}
