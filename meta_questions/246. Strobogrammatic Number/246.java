class Solution {
    public boolean isStrobogrammatic(String num) {

        for(int i = 0; i < num.length(); i++) {

            int j = num.length()-i-1;
            if(num.charAt(i) == '0' && num.charAt(j) == '0') continue;
            if(num.charAt(i) == '1' && num.charAt(j) == '1') continue;
            if(num.charAt(i) == '8' && num.charAt(j) == '8') continue;
            if(num.charAt(i) == '6' && num.charAt(j) == '9') continue;
            if(num.charAt(i) == '9' && num.charAt(j) == '6') continue;

            return false;
        }
        return true;
    }
}
