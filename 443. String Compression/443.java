class Solution {
    public int compress(char[] chars) {

        String ans = "";

        for(int i = 0; i < chars.length; i++) {
            int count = 1;
            ans += chars[i];
            // count no of consecutive chars
            while(i < chars.length-1 && chars[i] == chars[i+1]) {
                count++; 
                i++;
            }
            // add to ans if count > 1
            if(count > 1) ans += count;
        }

        // fill chars array with characters
        for(int i = 0; i < chars.length; i++) {
            if(i < ans.length()) chars[i] = ans.charAt(i);
        }

        return ans.length();
    }
}
