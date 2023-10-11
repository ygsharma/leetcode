class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        // sorting array based on end time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        // take left, right and count variable
        int l = 0, r = 1, count = 0;
        while(r < intervals.length) {
            // if start time of right > end time of left = they are non-overlapping
            if(intervals[r][0] >= intervals[l][1]) {
                l = r;
            }
            else{
                count++;
            }
            r++;
        }
        return count;
    }
}
