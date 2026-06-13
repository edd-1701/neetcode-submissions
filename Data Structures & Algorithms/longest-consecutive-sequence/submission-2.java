class Solution {
    public int longestConsecutive(int[] nums) {
        final var numSet = new TreeSet<Integer>();

        for (var num : nums) {
            numSet.add(num);
        }

        var maxSequence = 0;
        var currSequence = 0;
        Integer lastNum = null;
        for (var num : numSet) {
            if (lastNum == null) {
                currSequence = 1;
            } else {
                final var sequenceDelta = num == (lastNum + 1) ? 1 : -currSequence + 1;
                currSequence += sequenceDelta;
            }

            if (currSequence > maxSequence) {
                maxSequence = currSequence;
            }

            lastNum = num;
        }

        return maxSequence;
    }
}
