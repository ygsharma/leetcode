class Solution {
    public String customSortString(String order, String s) {
        

        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c-'a']++;

        StringBuilder ans = new StringBuilder();

        // Write all characters that occur in order, in the order of order.
        for(char c : order.toCharArray()) {
            for(int i = 0; i < count[c - 'a']; i++) ans.append(c);
            count[c-'a'] = 0;
        }

        // Write all remaining characters that don't occur in S.
        // That information is specified by 'count'.
        for(char c = 'a'; c <= 'z'; c++) {
            for(int i = 0; i < count[c-'a']; i++) ans.append(c);
        }

        return ans.toString();
    }
}
