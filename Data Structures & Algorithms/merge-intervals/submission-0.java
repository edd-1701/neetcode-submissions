class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        var result = new ArrayList<int[]>();

        for (var interval : intervals) {
            if (result.isEmpty() || interval[0] > result.getLast()[1]) {
                result.add(interval);
                continue;
            }
            final var latest = result.getLast();
            latest[1] = Math.max(interval[1], latest[1]);
        }


        return result.toArray(new int[0][2]);
    }
}
