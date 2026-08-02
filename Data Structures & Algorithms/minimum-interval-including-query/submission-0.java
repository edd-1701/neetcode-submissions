class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> {
            final var durationA = a[1] - a[0] + 1;
            final var durationB = b[1] - b[0] + 1;
            // return durationA == durationB ? a[0] - b[0] : durationA - durationB;
            if (durationA != durationB) {
                return durationA - durationB;
            } else {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[1];
            }
            // a[0] == b[0] ? a[1] - b[1] : a[0] - b[1]
        });

        final var result = new int[queries.length];
        // Arrays.fill(result, -1);
        for (var i = 0; i < queries.length; i++) {
            result[i] = scan(queries[i], intervals);
        }

        return result;
    }

    private static int scan(int query, int[][] intervals) {
        var result = -1;

        for (var interval : intervals) {
            final var start = interval[0];
            final var end = interval[1];

            if (start <= query && end >= query) {
                return end - start + 1;
            }
        }

        return result;
    }

    // private static int findShortest(int query, int[][] intervals) {
    //     var result = -1;
    //     var minDuration = -1;

    //     var left = 0;
    //     var right = intervals.length - 1;

    //     while (left <= right) {
    //         final var middle = (left + right) / 2;

    //         final var start = intervals[middle][0];
    //         final var end = intervals[middle][1];
    //         final var duration = end - start + 1;

    //         if (start >= query && end >= query) {
    //             if (result == -1 || duration < minDuration) {
    //                 result = middle;
    //                 minDuration = duration;
    //             }
    //             right = middle - 1;
    //         } else if (start > query || end < query) {
    //             //When do I want to move forward in time
    //             // when the middle start is after the search time
    //             // when the middle end  is before the searh time
    //             right = middle - 1;
    //         } else {
    //             left = middle + 1;
    //         }
    //     }

    //     return result;
    // }
}
