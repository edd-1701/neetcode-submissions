class PrefixTree {

    class TrieNode {
        char character;
        boolean isEndOfWord;
        Map<Character, TrieNode> children;

        public TrieNode(char character) {
            this.character = character;
            isEndOfWord = false;
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode('*');
    }

    public void insert(String word) {
        var currentNode = root;
        for (var i = 0; i < word.length(); i++) {
            final var currChar = word.charAt(i);
            currentNode = currentNode.children.computeIfAbsent(currChar, k -> new TrieNode(k));
        }
        currentNode.isEndOfWord = true;
    }

    public boolean search(String word) {
        var currentNode = root;
        for (var i = 0; i < word.length(); i++) {
            final var currChar = word.charAt(i);
            currentNode = currentNode.children.get(currChar);
            if (currentNode == null) {
                return false;
            }
        }

        return currentNode.isEndOfWord;        
    }

    public boolean startsWith(String prefix) {
        var currentNode = root;
        for (var i = 0; i < prefix.length(); i++) {
            final var currChar = prefix.charAt(i);
            currentNode = currentNode.children.get(currChar);
            if (currentNode == null) {
                return false;
            }
        }

        return true;
    }
}
