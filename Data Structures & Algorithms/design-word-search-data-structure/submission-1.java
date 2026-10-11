class TrieNode {
    public char letter;
    public boolean isEndOfWord;
    public Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(char letter) {
        this.letter = letter;
    }
}

class WordDictionary {
    final TrieNode rootNode = new TrieNode('*');

    public WordDictionary() {}

    public void addWord(String word) {
        var currNode = rootNode;

        final var chars = word.toCharArray();
        for (var letter : chars) {
            currNode = currNode.children.computeIfAbsent(letter, k -> new TrieNode(k));
        }

        currNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        var nodeQueue = new ArrayDeque<TrieNode>();
        nodeQueue.addFirst(rootNode);

        final var chars = word.toCharArray();
        for (var letter : chars) {
            final var nextQueue = new ArrayDeque<TrieNode>();

            while (!nodeQueue.isEmpty()) {
                final var currNode = nodeQueue.pollFirst();
                

                if (letter == '.') {
                    currNode.children.forEach((k, v) -> {
                        nextQueue.addLast(v);
                    });
                } else if (currNode.children.containsKey(letter)) {
                    nextQueue.push(currNode.children.get(letter));
                }
            }

            nodeQueue = nextQueue;
        }

        while (!nodeQueue.isEmpty()) {
            if (nodeQueue.pollFirst().isEndOfWord) {
                return true;
            }
        }
        return false;
    }
}
