class Solution {
    public int maxArea(int[] height) {

        int l = 0, r = height.length-1;
        int tmax = 0;
        while(l < r) {
            if(height[l] < height[r]) {
                tmax = Math.max(tmax, height[l]*(r-l));
                l++;
            }
            else{
                tmax = Math.max(tmax, height[r]*(r-l));
                r--;
            }

        }
        return tmax;
    }
}
