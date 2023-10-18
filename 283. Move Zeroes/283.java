class Solution {
    public void moveZeroes(int[] nums) {

        if(nums.length == 1) return;
        
        int l = 0, r = 1;

        while(r < nums.length) {
            // if l == 0 and r!= 0 swap
            if(nums[l] == 0 && nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++; r++;
            }  
            // if both l=r=0 r++ till we get r!=0
            else if(nums[l] == 0 && nums[r] == 0){
                while(r < nums.length && nums[r] == 0) r++;
            }
            else {
                l++; r++;
            }
        }

        return;
    }
}
