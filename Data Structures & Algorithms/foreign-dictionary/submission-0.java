class Solution {
    private HashMap<Character, Set<Character>> adj = new HashMap<>();
    private Map<Character, Boolean> visited = new HashMap<>();
    private List<Character> result = new ArrayList<>();

    public String foreignDictionary(String[] words) {
        for (var word : words) {
            for (var chr : word.toCharArray()) {
                adj.computeIfAbsent(chr, k -> new HashSet<Character>());
            }
        }

        for (var i = 0; i < words.length - 1; i++) {
            final var w1 = words[i];
            final var w2 = words[i + 1];

            final var minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length()
                && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }

            for (var j = 0; j < minLen; j++) {
                if (w1.charAt(j) == w2.charAt(j)) {
                    continue;
                }
                adj.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
        }

        for (var c : adj.keySet()) {
            if (hasCycle(c)) {
                return "";
            }
        }

        final var result = new StringBuilder();
        for (var i = this.result.size() - 1; i >= 0; i--) {
            result.append(this.result.get(i));
        }

        return result.toString();
    }

    private boolean hasCycle(char chr) {
        if (visited.containsKey(chr)) {
            return visited.get(chr);
        }

        visited.put(chr, true);
        for (char nei : adj.get(chr)) {
            if (hasCycle(nei)) {
                return true;
            }
        }
        visited.put(chr, false);
        result.add(chr);
        return false;
    }
}
