class Solution {
    public int[] findBuildings(int[] heights) {
        
        List<Integer> li = new ArrayList<>();
        int maxHeight = -1;
        // start from right, add in list if maxHeight<curr_height and update maxHeight
        for(int i = heights.length-1; i >= 0; i--) {
            if(maxHeight < heights[i]) {
                li.add(i);
                maxHeight = heights[i];  
            }
        }

        // store in ans
        int[] ans = new int[li.size()];
        for(int i = 0; i < li.size(); i++) ans[i] = li.get(li.size()-i-1);

        return ans;
    }
}
