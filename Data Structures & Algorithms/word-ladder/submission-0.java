/*

Build an adjacency list of words that differ by one character

then perform BFS to hop from begin to end

*/

record QueueEntry(String word, int steps){};
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final var graph = buildGraph(beginWord, endWord, wordList);
        final var visited = new HashSet<String>();


        if (!graph.containsKey(endWord)) {
            return 0;
        }

        // System.out.println("Graph: " + graph);

        final var queue = new ArrayDeque<QueueEntry>();
        queue.add(new QueueEntry(beginWord, 1));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            final var state = queue.pollFirst();
            final var currWord = state.word;

            if (currWord.equals(endWord)) {
                return state.steps;
            }

            final var neis = graph.getOrDefault(currWord, Set.of());
            for (var nei : neis) {
                if (visited.contains(nei)) {
                    continue;
                }

                queue.add(new QueueEntry(nei, state.steps + 1));
                visited.add(nei);
            }
        }

        return 0;
    }


    private Map<String, Set<String>> buildGraph(String begin, String end, List<String> words) {
        final var result = new HashMap<String, Set<String>>();

        final var tmp = new ArrayList<String>();
        tmp.add(begin);
        // tmp.add(end);
        tmp.addAll(words);

        for (var word1 : tmp) {
            final var validNodes =  new HashSet<String>();
            for (var word2 : tmp) {
                if (word1.equals(word2) || word2.equals(begin)) {
                    continue;
                }
                if (differByOne(word1, word2)) {
                    validNodes.add(word2);
                }
            }
            result.put(word1, validNodes);
        }

        return result;
    }

    private static boolean differByOne(String str1, String str2) {
        var diff = 0;
        for (var i = 0; i < str1.length(); i++) {
            diff += str1.charAt(i) == str2.charAt(i) ? 0 : 1;
        }
        return diff == 1;
    }
}
