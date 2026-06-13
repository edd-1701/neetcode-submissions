class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        
        var result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<>());

        for (var num : nums) {
            // final var resultOriginalLen = result.size();
            final var tmpResult = new ArrayList<List<Integer>>();
            for (var resultSubset : result) {
                for (var i = 0; i <= resultSubset.size(); i++) {
                    final var subsetCopy = new ArrayList<>(resultSubset);
                    subsetCopy.add(i, num);
                    tmpResult.add(subsetCopy);
                }
                // System.out.println("What is result size here???:" + result);
            }
            result = tmpResult;
        }

        // System.out.println("result at end??? " + result);
        return result;
    }
}
