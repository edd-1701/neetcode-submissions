class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (var num : nums) {
            final var initialSize = result.size();
            for (var i = 0; i < initialSize; i++) {
                result.add(new ArrayList<>(result.get(i)));
                result.get(i).add(num);
            }
                
            }



        return result;        
    }

}
