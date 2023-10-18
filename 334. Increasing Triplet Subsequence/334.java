class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;

        for(int i : nums) {
            // update max1
            if(i <= max1) max1 = i;
            // update max2
            else if(i <= max2) max2 = i;
            // if i > max1 and i > max2 we got the sequence
            else return true;
        }
        return false;
    }
}
