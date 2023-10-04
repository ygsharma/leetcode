class MinStack {
    private int[] stack = new int[50];
    private int top = -1;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        // int size;
    }
    
    public void push(int val) {
        
        if(top < stack.length-1) {
            ++top;
            stack[top] = val;
        }
        else{
            int[] arr = new int[2*stack.length];
            for(int i = 0; i < stack.length; i++) {
                arr[i] = stack[i];
            }
            stack = arr;
            stack[++top] = val;
           
        }
        if(val < min) min = val;

        return;
    }
    
    public void pop() {

        if(top == -1) return;
        
        if(stack[top] == min) {
            min = Integer.MAX_VALUE;
            for(int i = 0; i < top; i++) {
                if(min > stack[i]) min = stack[i];
            }
        }
        top--;
        return;
    }
    
    public int top() {
        if(top == -1){
            return -1;
        }
        return stack[top];
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
