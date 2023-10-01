class Solution {
    public void nextPermutation(int[] nums) {

        if(nums.length == 1) return;

        int index = -1;

        for(int i = nums.length-2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                index = i; break;
            }
        }

        if(index == -1) reverse(nums, 0);
        else {
        
            for(int i = nums.length-1; i>=0; i--) {
                if(nums[i] > nums[index]) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }

            reverse(nums, index+1);
        }

        return;
    }

    public void reverse(int[] nums, int start) {
        
        int l = start, r = nums.length-1;
        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }

        return;
    }
}
