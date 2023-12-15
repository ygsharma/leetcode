class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        // Using Boyer-Moore Voting Algorithm
        // There can be atmost 2 element ocuuring > n/3 times
        // we take 2 counts and candidates
        // We'll check in last if they both occuring > n/3

        List<Integer> ans = new ArrayList<>();
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;

        for(int i = 0; i < nums.length; i++) {
            if(candidate1 != null && candidate1.intValue() == nums[i]) count1++;
            else if(candidate2 != null && candidate2.intValue() == nums[i]) count2++;
            else if(count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            }
            else{
                count1--; count2--;
            }
        }

        count1 = 0; count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(candidate1 != null && nums[i] == candidate1.intValue()) count1++;
            if(candidate2 != null && nums[i] == candidate2.intValue()) count2++;
        }

        if(nums.length/3 < count1) ans.add(candidate1);
        if(nums.length/3 < count2) ans.add(candidate2);

        return ans;
    }
}
