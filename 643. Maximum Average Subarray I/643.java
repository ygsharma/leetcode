class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int sum = 0;
        for(int i = 0; i < k; i++) sum += nums[i];

        int tmax = sum;

        int r = k;
        while(r < nums.length) {
            // add new right index and remove last left index element 
            sum = sum + nums[r] - nums[r-k];
            tmax  = Math.max(tmax, sum);
            r++;
        }

        return (double)tmax/k;
    }
}
