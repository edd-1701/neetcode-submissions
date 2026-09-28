class Solution {
    public int findDuplicate(int[] nums) {
        final var numsSeen = new HashSet<Integer>();

        for (var num : nums) {
            if (!numsSeen.add(num)) {
                return num;
            }
        }

        return 0;
    }
}
