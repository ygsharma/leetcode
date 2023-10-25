class Solution {
    public int deleteAndEarn(int[] nums) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i : nums) hm.put(i, hm.getOrDefault(i,0)+1);
       
        int[] arr = new int[hm.keySet().size()];
        int i = 0;
        for(Integer key: hm.keySet()) {
            arr[i] = key;
            i++;
        }
        Arrays.sort(arr);
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);

        return dp(arr, 0, hm, memo);
    }


    public int dp(int[] arr, int i, HashMap<Integer, Integer> hm, int[] memo) {

        if(i == arr.length) return 0;
        
        if(memo[i] != -1) return memo[i];

        int notTake = dp(arr, i+1, hm, memo);
        int take = arr[i]*hm.get(arr[i]);

        if(i+1 < arr.length && arr[i]+1 == arr[i+1]) take += dp(arr, i+2, hm, memo);
        else if(i+1 < arr.length && arr[i]+1 != arr[i+1]) take += dp(arr, i+1, hm, memo);

        return memo[i] = Math.max(take, notTake);

    }
}
