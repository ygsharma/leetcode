class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(k, 1, n, new ArrayList<Integer>(), ans);
        return ans;
        
    }

    public void backtrack(int k, int idx, int target, List<Integer> li, List<List<Integer>> ans) {

        if(target == 0 && li.size() == k) {
            ans.add(new ArrayList<>(li));
            return;
        }

        if(idx > 9 || target < 0 || li.size() > k) return;

        li.add(idx);
        backtrack(k, idx+1, target-idx, li, ans);
        li.remove(li.size()-1);

        backtrack(k, idx+1, target, li, ans);

        return;
    }
}
