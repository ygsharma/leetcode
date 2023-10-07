class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int[] ans = new int[3];
    
        for(int[] arr : triplets) {
            if(arr[0]>target[0] || arr[1]>target[1] || arr[2]>target[2]) continue;
            else{
               ans[0] = Math.max(arr[0], ans[0]);
               ans[1] = Math.max(arr[1], ans[1]);
               ans[2] = Math.max(arr[2], ans[2]);
               
               if(Arrays.equals(ans, target)) return true;
            }
        }
        return false;
    }
}
