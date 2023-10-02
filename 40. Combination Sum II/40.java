class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(int[] nums, int idx, int target, List<Integer> li, List<List<Integer>> ans) {

        if(target == 0) {
            ans.add(new ArrayList<>(li));
            return;
        }
      
        if(idx == nums.length || target < 0) return;

        li.add(nums[idx]);
        backtrack(nums, idx+1, target-nums[idx], li, ans);
        li.remove(li.size()-1);

        while(idx+1 < nums.length && nums[idx] == nums[idx+1]) idx++;
        backtrack(nums, idx+1, target, li, ans);

        return;
    }
}
