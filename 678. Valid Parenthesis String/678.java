class Solution {
    public boolean checkValidString(String s) {
        
        // take 2 var for character count
        int cmax=0, cmin = 0;
        for(Character c : s.toCharArray()) {
            // if '(' increment both variable
            if(c == '(') {
                cmax++;
                cmin++;
            }
            else if(c == ')') {
                cmax--;
                cmin--;
            }
            // cmax++ for replacing * as '(' option
            // cmin-- for replacing * as ')' option
             else if(c == '*') {
                cmax++;
                cmin--;
            }
            if(cmax < 0) return false;
            cmin = Math.max(cmin, 0);
        }
        return cmin == 0;
    }
}
