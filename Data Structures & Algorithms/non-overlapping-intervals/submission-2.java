class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        var result = 0;
        var lastEndTime = intervals[0][1];

        for (var i = 1; i < intervals.length; i++) {
            final var curr = intervals[i];
            //interval 
            if (curr[0] >= lastEndTime) {
                lastEndTime = curr[1];
            } else {
                result += 1;
                lastEndTime = Math.min(curr[1], lastEndTime);
            }
        }


        return result;
    }
}
