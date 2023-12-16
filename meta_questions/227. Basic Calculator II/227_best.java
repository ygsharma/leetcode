class Solution {
    public int calculate(String s) {
        
        int curr = 0, result = 0, last = 0;
        char operator = '+';
        

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                curr = curr*10 + ch - '0';
            }
            if(!Character.isDigit(ch) && ch != ' ' || i == s.length()-1) {
                if(operator == '+') {
                    result += last;
                    last = curr;
                }
                else if(operator == '-') {
                    result += last;
                    last = -curr;
                }
                else if(operator == '*') {
                    last *= curr;
                }
                else if(operator == '/') {
                    last /= curr;
                }
                curr = 0;
                operator = ch;
            }
        }
        return result+last;
    }

    /* Approach
    1. Instead of using a stack, we use a variable lastNumber to track the value of the last evaluated 
       expression.
    2. If the operation is Addition (+) or Subtraction (-), add the lastNumber to the result instead of 
       pushing it to the stack. The currentNumber would be updated to lastNumber for the next iteration. 
    3. If the operation is Multiplication (*) or Division (/), we must evaluate the expression lastNumber 
       * currentNumber and update the lastNumber with the result of the expression. This would be added to 
       the result after the entire string is scanned.
    */
}
