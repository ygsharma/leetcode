class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> li = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, li, ans);
        return ans;
    }

    public void helper(int[] nums, int target, int idx, List<Integer> li, List<List<Integer>> ans) {

        if(target == 0) {
            ans.add(new ArrayList<>(li));
            return;
        }

        if(idx == nums.length || target < 0) {
            return;
        }
        
        li.add(nums[idx]);
        helper(nums, target-nums[idx], idx, li, ans);
    
        li.remove(li.size()-1);
        helper(nums, target, idx+1, li, ans);
    }
}
