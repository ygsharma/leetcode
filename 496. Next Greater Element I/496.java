class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        // for getting next greater element
        for(int i = nums2.length-1; i >= 0; i--) {

            // if stack not empty and top element < array element -> pop
            while(!stack.empty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            // if stack empty: greater element = -1, push curr element
            // else greater element = top of stack
            if(stack.empty()) {
                if(map.containsKey(nums2[i])) {
                    ans[map.get(nums2[i])] = -1;
                }
                stack.push(nums2[i]);
            }
            else{
                if(map.containsKey(nums2[i])) {
                    ans[map.get(nums2[i])] = stack.peek();
                }
                stack.push(nums2[i]);
            }
        }
        return ans;
    }
}
