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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

        for (var i = 1; i < intervals.size(); i++) {
            final var prev = intervals.get(i-1);
            final var curr = intervals.get(i);

            if (curr.start < prev.end) {
                return false;
            }
        }
        return true;
    }
}
