class Solution {
    public int longestConsecutive(int[] nums) {
        final var numSet = new TreeSet<Integer>();
        final var frequencies = new HashMap<Integer, Integer>();

        for (var num : nums) {
            numSet.add(num);
            frequencies.merge(num, 1, Integer::sum);
        }

        // System.out.println("Frequencies : " + frequencies);
        System.out.println("numSet : " + numSet);

        var maxSequence = 0;
        var currSequence = 0;
        Integer lastNum = null;
        for (var num : numSet) {
            if (lastNum == null) {
                currSequence = 1;
            } else {
                if (num == lastNum + 1) {
                    currSequence += 1;
                } else {
                    currSequence = 1;
                }
            }

            if (currSequence > maxSequence) {
                maxSequence = currSequence;
            }

            lastNum = num;

            // if (frequencies.get(num) > 1) {
            //     currSequence = 1;
            // }
        }


        return maxSequence;
    }
}
