class SparseVector {
    
    private int[] nums;
    SparseVector(int[] nums) {
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
        int ans = 0;
        for(int i = 0; i < vec.nums.length; i++) {
            if(vec.nums[i] != 0 && this.nums[i] != 0) ans += vec.nums[i] * this.nums[i];
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
