class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] ps = prevSmaller(heights);
        int[] ns = nextSmaller(heights);

        System.out.println("ps" + Arrays.toString(ps));
        System.out.println("ns" + Arrays.toString(ns));

        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (ns[i]-ps[i]-1)*heights[i]);  
        }
        return maxArea;
    }

    // function to find previous smaller element index for each element 
    public int[] prevSmaller(int[] heights) {
        
        int[] ps = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < heights.length; i++) {

            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            // -1 if no next smaller
            ps[i] = st.empty() ? -1 : st.peek();
            st.push(i);
        }
        return ps;
    }

    // function to find next smaller element index for each element
    public int[] nextSmaller(int[] heights) {
        
        int[] ns = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        for(int i = heights.length-1; i >= 0; i--) {

            while(!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            
            // heights.length if no next smaller
            ns[i] = st.empty() ? heights.length : st.peek();
            st.push(i);
        }
        return ns;
    }
    
}
