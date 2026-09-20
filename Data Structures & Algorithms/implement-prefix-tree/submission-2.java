class TrieNode {
    char letter;
    boolean endOfWord;
    Map<Character, TrieNode> children = children = new HashMap<>();

    public TrieNode(char letter) {
        this.letter = letter;
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode('*');
    }

    public void insert(String word) {
        var node = root;

        for (var i = 0; i < word.length(); i++) {
            final var currChar = word.charAt(i);
            node = node.children.computeIfAbsent(currChar, key -> new TrieNode(currChar));
        }

        node.endOfWord = true;
    }

    public boolean search(String word) {
        var node = root;

        for (var i = 0; i < word.length(); i++) {
            final var currChar = word.charAt(i);
            node = node.children.get(currChar);

            if (node == null) {
                return false;
            }
        }

        return node.endOfWord;
    }

    public boolean startsWith(String prefix) {
        var node = root;

        for (var i = 0; i < prefix.length(); i++) {
            final var currChar = prefix.charAt(i);
            node = node.children.get(currChar);

            if (node == null) {
                return false;
            }
        }

        return true;
    }
}
