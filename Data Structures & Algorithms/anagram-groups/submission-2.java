class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final var anagramMap = new HashMap<String, List<String>>();

        for (var str : strs) {
            final var key = getKey(str);
            anagramMap.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
        }

        final var result = new ArrayList<List<String>>();
        for (var vals : anagramMap.values()) {
            result.add(vals);
        }

        return result;
    }

    private static String getKey(String str) {
        final var chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}
