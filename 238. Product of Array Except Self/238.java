class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);

        // prefix product 
        int curr = 1;
        for(int i = 0; i < nums.length; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        } 

        // suffix product
        curr = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }
}
