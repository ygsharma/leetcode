class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        // find max in nums
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[max] < nums[i]) max = i;
        }

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        // start from max go to left 
        for(int i = max; i >= 0; i--) {
            while(!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            if(stack.empty()) {
                ans[i] = -1;
                stack.push(nums[i]);
            }
            else{
                ans[i] = stack.peek();
                stack.push(nums[i]);
            }
        }

        // start going left from n-1 
        for(int i = nums.length-1; i > max; i--) {
            while(!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            if(stack.empty()) {
                ans[i] = -1;
                stack.push(nums[i]);
            }
            else{
                ans[i] = stack.peek();
                stack.push(nums[i]);
            }
        }

        return ans;
    }
}
