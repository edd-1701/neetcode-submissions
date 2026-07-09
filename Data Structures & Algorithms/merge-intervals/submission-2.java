class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        var result = new ArrayList<int[]>();
        for (var interval : intervals) {
            if (result.isEmpty() || interval[0] > result.getLast()[1]) {
                result.add(interval);
            } else if (interval[1] > result.getLast()[1]) {
                result.getLast()[1] = interval[1];
            }
        }

        return result.toArray(new int[0][2]);
    }
}
