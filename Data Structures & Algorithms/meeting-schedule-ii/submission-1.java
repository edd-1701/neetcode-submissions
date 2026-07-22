/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }

        intervals.sort((a, b) -> a.start - b.start);

        final var roomHeap = new PriorityQueue<Integer>();
        roomHeap.add(intervals.get(0).end);
        var minRooms = 1;

        for (var i = 1; i < intervals.size(); i++) {
            final var current = intervals.get(i);

            if (!roomHeap.isEmpty() && current.start >= roomHeap.peek()) {
                roomHeap.poll();
            }

            roomHeap.add(current.end);

            if (roomHeap.size() > minRooms) {
                minRooms = roomHeap.size();
            }
        }

        return minRooms;
    }
}
