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

    Iterative solution:



*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // final var iterativeResult = new ArrayList<List<Integer>>();
        // helperIterative(nums, new ArrayList<Integer>(), new boolean[nums.length], iterativeResult);
        // return iterativeResult;

        return helperIterative(nums);
    }

    private List<List<Integer>> helperIterative(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        for (var num : nums) {
            final var tmpResult = new ArrayList<List<Integer>>();

            for (var subset : result) {
                for (var i = 0; i <= subset.size(); i++) {
                    final var copy = new ArrayList<>(subset);
                    copy.add(i, num);
                    tmpResult.add(copy);
                }
            }

            result = tmpResult;
        }


        return result;
    }

    private void helperRecursive(int[] nums, List<Integer> subset, boolean[] usedIdxs, List<List<Integer>> result) {
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
            helperRecursive(nums, subset, usedIdxs, result);
            subset.removeLast();
            usedIdxs[i] = false;
        }
    }
}
