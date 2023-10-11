class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        int[] prev = intervals[0];
        int i = 1;
        while(i < intervals.length) {

            if(prev[1] < intervals[i][0]) {
                list.add(prev);
                prev = intervals[i];
            }
            else {
                prev[0] = Math.min(intervals[i][0], prev[0]);
                prev[1] = Math.max(intervals[i][1], prev[1]);
            }
            i++;
        }
        list.add(prev);

        return list.toArray(new int[list.size()][2]);

    }
}
