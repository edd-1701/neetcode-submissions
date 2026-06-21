class Solution {
    private final static Map<Character, List<Character>> MAPPING = Map.of(
        '2', List.of('a','b','c'),
        '3', List.of('d','e','f'),
        '4', List.of('g','h','i'),
        '5', List.of('j','k','l'),
        '6', List.of('m','n','o'),
        '7', List.of('p','q','r', 's'),
        '8', List.of('t','u','v'),
        '9', List.of('w','x','y','z')
    );

    private List<String> result = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        backtrack(0, new StringBuilder());
        return result;
    }

    private void backtrack(int indexAt, StringBuilder subset) {
        if (subset.length() == digits.length() && !subset.isEmpty()) {
            result.add(subset.toString());
        }
        if (indexAt >= digits.length()) {
            return;
        }

        for (var chr : MAPPING.get(digits.charAt(indexAt))) {
            subset.append(chr);
            backtrack(indexAt + 1, subset);
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
