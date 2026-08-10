class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var frequencies = new HashMap<Integer, Integer>();
        for (var num : nums) {
            frequencies.merge(num, 1, Integer::sum);
        }

        final var values = new ArrayList<Map.Entry<Integer, Integer>>(frequencies.entrySet());
        values.sort((a, b) -> b.getValue() - a.getValue());

        final var result = new int[k];
        for (var i = 0; i < k; i++) {
            result[i] = values.get(i).getKey();
        }
        return result;
    }
}
