class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int zeroCount = 0;

        int i = 0; int j;
        for(j = 0; j < nums.length; j++) {
            // increment zero count if right index j has 0 value
            if(nums[j] == 0) zeroCount++;

            // if zeros>k increment left index and if left index was zero -> decrement zeros count
            if(zeroCount > k) {
                if(nums[i] == 0) zeroCount--;
                i++;
            }
        }
        // if zeros>k : we'll have only 1 extra 0 so j-i will work or else the answer would be j-i+1
        // if zeros<k : then this can be our answer coz we fulfill the condition
        return j-i;
    }
}
