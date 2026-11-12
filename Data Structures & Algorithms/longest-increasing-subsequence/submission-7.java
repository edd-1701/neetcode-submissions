/**

    This is a Dynamic Programming,
    Top-down recursive with memoization: I'd need a recursive function
        helper(int i, int parentIndex):
        from a function like this I can get the the max
        At each number, I have two options
            - (only if currentNum is greater than parent), increment result by one and continue;
            - skip currNum, and try sequence with next num

*/

class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        return helper(0, -1, nums);
    }

    private int helper(int i, int parentIdx, int[] nums) {
        if (i == nums.length) {
            return 0;
        }

        final var memoKey = "" + i + "," + parentIdx;
        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        var resultFromPrev = -1;
        if (parentIdx == -1 || nums[i] > nums[parentIdx]) {
            resultFromPrev = 1 + helper(i + 1, i, nums);
        }

        var resultFromSkip = helper(i + 1, parentIdx, nums);

        final var result = Math.max(resultFromPrev, resultFromSkip);
        memo.put(memoKey, result);
        return result;
    }
}
