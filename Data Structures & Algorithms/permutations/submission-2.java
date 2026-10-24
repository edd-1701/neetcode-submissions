/*
    
    Recursive solution:
        design a recursive function that contains the current subset and the used indexes
        when the subset has exhausted the input array, add to result
        init loop from 0..len(nums):
            if index is used, continue loop
            add num to subset
            add index to usedIndexes
            call recursive input
            backtrack and remove just added num




*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        final var iterativeResult = new ArrayList<List<Integer>>();
        helperIterative(nums, new ArrayList<Integer>(), new boolean[nums.length], iterativeResult);

        return iterativeResult;
    }

    private void helperIterative(int[] nums, List<Integer> subset, boolean[] usedIdxs, List<List<Integer>> result) {
        if (subset.size() == nums.length) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }

        for (var i = 0; i < nums.length; i++) {
            if (usedIdxs[i]) {
                continue;
            }

            subset.add(nums[i]);
            usedIdxs[i] = true;
            helperIterative(nums, subset, usedIdxs, result);
            subset.removeLast();
            usedIdxs[i] = false;
        }
    }
}
