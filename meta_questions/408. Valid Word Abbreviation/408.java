class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int number = 0;
        int len = 0;
        for(int i = 0; i < abbr.length(); i++) {
            char ch = abbr.charAt(i);
            if(Character.isDigit(ch)) {
                if(number == 0 && ch - '0' == 0) return false; 
                number = number*10 + ch - '0';
            }
            else {
                len += number;
                number = 0;
                if (len >= word.length() || word.charAt(len) != ch) return false;
                len++;
            }
        }
        return word.length() == len+number;
    }
}
