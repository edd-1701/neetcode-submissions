class TrieNode{
    char letter;
    boolean isEndOfWord;
    boolean wordFound;
    Map<Character, TrieNode> children;


    public TrieNode(char letter) {
        this.letter = letter;
        isEndOfWord = false;
        children = new HashMap<>();
    }
}

class Solution {
    private static final List<List<Integer>> DIRECTIONS = List.of(
        List.of(1, 0), List.of(-1, 0), List.of(0, 1), List.of(0, -1)
    );
    private char[][] board;
    private TrieNode root;
    private boolean[][] visited;
    private List<String> result;
    private int ROWS;
    private int COLS;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        root = buildTrie(words);
        visited = new boolean[board.length][board[0].length];
        result = new ArrayList<>();
        ROWS = board.length;
        COLS = board[0].length;

        for (var row = 0; row < ROWS; row++) {
            for (var col = 0; col < COLS; col++) {
                final var currChar = board[row][col];
                final var node = root.children.get(currChar);
                if (node == null) {
                    continue;
                }
                dfs(row, col, new StringBuilder(), node);
            }
        }

        return result;
    }

    private void dfs(int row, int col, StringBuilder str, TrieNode node) {
        final var currChar = board[row][col];

        str.append(currChar);
        visited[row][col] = true;

        if (node.isEndOfWord && !node.wordFound) {
            result.add(str.toString());
            node.wordFound = true;
        }

        // if (result.size() == wordCount) {
        //     return;
        // }

        for (var dir : DIRECTIONS) {
            final var newRow = row + dir.get(0);
            final var newCol = col + dir.get(1);

            if (isValidCell(newRow, newCol) &&
                !visited[newRow][newCol] &&
                node.children.containsKey(board[newRow][newCol])) {
                    dfs(newRow, newCol, str, node.children.get(board[newRow][newCol]));
            }
        }

        str.deleteCharAt(str.length() - 1);
        visited[row][col] = false;

    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    private TrieNode buildTrie(String[] words) {
        final var rootNode = new TrieNode('*');

        for (var word : words) {
            var currNode = rootNode;
            for (var i = 0; i < word.length(); i++) {
                final var currChar = word.charAt(i);
                currNode = currNode
                    .children
                    .computeIfAbsent(currChar, k -> new TrieNode(k));
            }
            currNode.isEndOfWord = true;
        }
        return rootNode;
    }
}
