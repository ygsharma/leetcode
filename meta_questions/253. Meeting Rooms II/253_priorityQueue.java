class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int[] arr : intervals) {
            if(!heap.isEmpty() && heap.peek() <= arr[0]) heap.poll();
            heap.add(arr[1]);
        }
        return heap.size();
    }
}
