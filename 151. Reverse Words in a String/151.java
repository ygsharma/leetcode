class Solution {
    public String reverseWords(String s) {
        
        String[] splited = s.trim().split("\\s+");

        int l = 0, r = splited.length-1;
        while(l < r) {
            String temp = splited[l];
            splited[l] = splited[r];
            splited[r] = temp;
            l++; r--;
        }

        StringBuilder ans = new StringBuilder();
        for(String str : splited) ans.append(str).append(" ");

        return ans.toString().trim();
    }
}
