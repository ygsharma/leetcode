class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') stack.push(c);

            if(c == ')') {
                if(stack.empty() || stack.peek() != '(') return false;
                else stack.pop();
            }
            if(c == '}') {
                if(stack.empty() || stack.peek() != '{') return false;
                else stack.pop();
            }
           if(c == ']') {
                if(stack.empty() || stack.peek() != '[') return false;
                else stack.pop();
            }
            i++;
        }
        return stack.empty();
    }
}
