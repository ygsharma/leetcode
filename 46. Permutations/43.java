class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];

        backtrack(nums, new ArrayList<Integer>(), ans, flag);
        return ans;
    }

    public void backtrack(int[] nums, List<Integer> li, List<List<Integer>> ans, boolean[] flag) {

        if(li.size() == nums.length) {
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!flag[i]) {
                flag[i] = true;
                li.add(nums[i]);
                backtrack(nums, li, ans, flag);
                li.remove(li.size()-1);
                flag[i] = !flag[i];
            }
        }
        return;
    }
}
