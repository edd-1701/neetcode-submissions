/*
    WTF: I don't even remember the solution for this.

    Create a treemap and put the input
    I now have the list sorted in log(n) time

*/

class Solution {
    public int longestConsecutive(int[] nums) {
        final var tree = new TreeSet<Integer>();
        for (var num : nums) {
            tree.add(num);
        }

        var maxRun = 0;
        var currentRun = 0;
        Integer lastNum = null;
        for (var num : tree) {
            if (lastNum == null || num != (lastNum + 1)) {
                currentRun = 1;
            } else {
                currentRun += 1;
            }

            if (currentRun > maxRun) {
                maxRun = currentRun;
            }

            lastNum = num;
        }

        return maxRun;
    }
}
