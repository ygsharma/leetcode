class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0, startPointer = 0, endPointer = 0;

        while(startPointer < start.length) {
            if(start[startPointer] >= end[endPointer]) {
                endPointer++; 
                rooms--;
            }
            rooms++;
            startPointer++;
        }
        return rooms;
    }
}
