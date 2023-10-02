class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<Integer>(), set);

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> li : set) {
            ans.add(li);
        }

        return ans;
    }

    public void backtrack(int[] nums, int i, List<Integer> li, Set<List<Integer>> set) {

        if(i == nums.length) {
            set.add(new ArrayList<>(li));
            return;
        } 
 
        li.add(nums[i]);
        backtrack(nums, i+1, li, set);
        li.remove(li.size()-1);
        backtrack(nums, i+1, li, set);

        return;
    }
}
