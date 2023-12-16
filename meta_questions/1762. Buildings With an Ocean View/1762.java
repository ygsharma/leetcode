class Solution {
    public int[] findBuildings(int[] heights) {
        
        List<Integer> li = new ArrayList<>();

        for(int i = 0; i < heights.length; i++) {
            while(!li.isEmpty() && heights[li.get(li.size()-1)] <= heights[i]) li.remove(li.size()-1);

            li.add(i);
        }

        int[] ans = new int[li.size()];
        for(int i = li.size()-1; i >= 0; i--) ans[i] = li.get(i);

        return ans;
    }
}
