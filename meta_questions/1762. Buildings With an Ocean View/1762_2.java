class Solution {
    public int[] findBuildings(int[] heights) {
        
        int[] maxRight = new int[heights.length];
        maxRight[maxRight.length-1] = heights[heights.length-1];

        for(int i = heights.length-2; i >= 0; i--) {
            maxRight[i] = Math.max(heights[i+1], maxRight[i+1]);
        }

        List<Integer> li = new ArrayList<>();

        for(int i = 0; i < heights.length; i++) {
            if(heights[i] > maxRight[i]) li.add(i);
        }

        li.add(heights.length-1);
        int[] ans = new int[li.size()];
        for(int i = 0; i < li.size(); i++) ans[i] = li.get(i);

        return ans;
    }
}
