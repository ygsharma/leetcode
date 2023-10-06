class Solution {
    public boolean canJump(int[] nums) {

        int goal = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            int jump = nums[i];
            if(i + jump >= goal){
                goal = i;
            }
        }

        return goal == 0;
        // return secondMethod(nums);
    }

     public boolean secondMethod(int[] nums) {
        int boundary = 0;
        for(int i = 0; i <= boundary; i++) {
            boundary = Math.max(boundary, i+nums[i]);
            if(boundary >= nums.length-1) return true;
        }
        return false;
        
    }

}
