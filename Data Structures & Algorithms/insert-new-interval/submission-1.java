class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        final var LEN = intervals.length;

        final var result = new ArrayList<int[]>();

        var i = 0;
        while (i < LEN && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i += 1;
        }

        while (i < LEN && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i += 1;
        }
        result.add(newInterval);

        while (i < LEN) {
            result.add(intervals[i]);
            i += 1;
        }

        return result.toArray(new int[result.size()][2]);
    }
}
