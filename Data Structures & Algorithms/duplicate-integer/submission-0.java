class Solution {
    public boolean hasDuplicate(int[] nums) {
        final var numSet = new HashSet<Integer>();
        for (var num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }

        return false;

        
    }
}