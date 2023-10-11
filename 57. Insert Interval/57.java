class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> li = new ArrayList<>();
        int i;
        for(i = 0; i < intervals.length; i++) {

        // when newInterval is after our interval just add interval and move
            if(intervals[i][1] < newInterval[0]) {
                li.add(intervals[i]);
            }
        // when newInterval is completely before our interval break the loop 
        // and insert newInterval after the loop
            else if(intervals[i][0] > newInterval[1]) {
                
                // newI
                break;

            }
        // when newInterval and interval overlaps then update newInterval
            else{
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        // add new Interval
        li.add(newInterval);
        
        // after inserting newInterval append the rest of the intervals array
        for(int j = i; j < intervals.length; j++) {
            li.add(intervals[j]);
        }

        return li.toArray(new int[li.size()][2]);
    }
}
