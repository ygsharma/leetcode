class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // size of freq is max-min+1 => to incorporate -ve values in nums
        // num-min is index for num in freq => represent frequency of num 
	int[] freq = new int[max-min+1];

        for(int num : nums) freq[num-min]++;

        for(int i = freq.length-1; i >= 0; i--) {
            k -= freq[i];
            if(k<=0) return i+min;
        }

        return -1;
    }
}
