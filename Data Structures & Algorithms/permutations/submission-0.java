class Solution {
    private int[] nums;
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        result = new ArrayList<>();

        helper(new ArrayList<Integer>(), new HashSet<Integer>());

        return result;
    }

    private void helper(List<Integer> subset, Set<Integer> indexesUsed) {
        if (subset.size() == nums.length) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }

        for (var i = 0; i < nums.length; i++) {
            if (indexesUsed.contains(i)) {
                continue;
            }

            subset.add(nums[i]);
            final var originalLen = subset.size();
            indexesUsed.add(i);

            helper(subset, indexesUsed);

            subset.remove(originalLen - 1);
            indexesUsed.remove(i);

        }
    }
}
