class Solution {
    public int calculate(String s) {
        
        int number = 0, result = 0;
        char operator = '+';
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                number = number*10 + ch - '0';
            }
            if(!Character.isDigit(ch) && ch != ' ' || i == s.length()-1) {
                if(operator == '+') {
                    st.push(number);
                }
                else if(operator == '-') {
                    st.push(-number);
                }
                else if(operator == '*') {
                    st.push(st.pop()*number);
                }
                else if(operator == '/') {
                    st.push(st.pop()/number);
                }
                number = 0;
                operator = ch;
            }
        }

        while(!st.isEmpty()) result += st.pop();
        return result;
    }
}
