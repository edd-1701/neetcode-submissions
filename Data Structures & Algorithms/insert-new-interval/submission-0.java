class Solution {
    //3 phases
    //intervals that end before newInterval start added in normally

    // if currentInterval ends before new Interval
    // newINtervalStart is the min start of both
    // newIntervalEnd is the max end of both
    // 
    //intervals that start after newInterval ends added in normally
    public int[][] insert(int[][] intervals, int[] newInterval) {

        final var LEN = intervals.length;

        var result = new ArrayList<int[]>();

        var i = 0;
        while (i < LEN && intervals[i][1] < newInterval[0]) {
            // System.out.println("Irrelevant Interval, adding normally: " + Arrays.toString(intervals[i]));
            result.add(intervals[i]);
            i += 1;
        }

        while (i < LEN && intervals[i][0] <= newInterval[1]) {
            // System.out.println("Merging %s : %s,".formatted(Arrays.toString(intervals[i]), Arrays.toString(newInterval)));
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            // System.out.println("\t merged: %s".formatted(Arrays.toString(newInterval)));
            i += 1;
        }

        result.add(newInterval);

        while (i < LEN && intervals[i][0] > newInterval[1]) {
            // System.out.println("Irrelevant Interval, adding normally: " + Arrays.toString(intervals[i]));
            result.add(intervals[i]);
            i += 1;
        }

        return result.toArray(new int[result.size()][2]);
    }
}
