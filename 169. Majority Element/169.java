class Solution {
    public int majorityElement(int[] nums) {

        // Moore's Voting Algorithm
        // The algorithm works on the basis of the assumption that the majority element occurs more than n/2 times in the array. 
        // This assumption guarantees that even if the count is reset to 0 by other elements, the majority element will 
        // eventually regain the lead.
        
        int count = 0, candidate = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) candidate = nums[i];
            if(nums[i] == candidate) count++;
            else count--;
        }
        return candidate;
    }
}
