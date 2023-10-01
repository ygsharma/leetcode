class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> li = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, li, ans);
        return ans;

    }

    public void helper(int[] nums, int idx, List<Integer> li, List<List<Integer>> ans) {

        if(idx >= nums.length) {
            ans.add(new ArrayList<>(li));
            return;
        }

        li.add(nums[idx]);
        helper(nums, idx+1, li, ans);

        li.remove(li.size()-1);
        helper(nums, idx+1, li, ans);
    }
}
