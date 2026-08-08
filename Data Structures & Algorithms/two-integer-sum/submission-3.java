class Solution {
    public int[] twoSum(int[] nums, int target) {
        // key: complement, value: index
        final var complement = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++) {
            final var num = nums[i];

            if (complement.containsKey(num)) {
                return new int[]{complement.get(num), i};
            }

            complement.put(target - num, i);
        }


        return new int[2];
    }
}
