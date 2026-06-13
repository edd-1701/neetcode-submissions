class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var frequencies = new HashMap<Integer,Integer>();

        for (var num : nums) {
            frequencies.merge(num, 1, Integer::sum);
        }

        final var frequencyList = new ArrayList<>(frequencies.entrySet());
        frequencyList.sort((a,b) -> Integer.compare(a.getValue(), b.getValue()));

        final var result = new int[k];
        for (var i = 0; i < k; i++) {
            result[i] = frequencyList.get(frequencyList.size() - 1 - i).getKey();
        }

        return result;

    }
    
}
