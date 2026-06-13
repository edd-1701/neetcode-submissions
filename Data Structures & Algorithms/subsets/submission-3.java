class Solution {
    int[] nums;
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        result = new ArrayList<>(); 

        helper(0, new ArrayList<>());

        return result;  
    }

    private void helper(int indexAt, List<Integer> list) {
        if (indexAt >= nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[indexAt]);
        helper(indexAt + 1, list);
        list.removeLast();
        helper(indexAt + 1, list);
    }
}
