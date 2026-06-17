class Solution {
    private char[][] board;
    private boolean[][] visited;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        this.word = word;

        final var firstChar = word.charAt(0);

        for (var row = 0; row < board.length; row++) {
            for (var col = 0; col < board[0].length; col++) {
                if (board[row][col] == firstChar && dfs(row, col, 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, int indexAt) {

        if (indexAt == word.length()) {
            return true;
        }

        final var charToMatch = word.charAt(indexAt);

        visited[row][col] = true;
        final var up = isValidCell(row-1, col) &&
            !visited[row-1][col] &&
            board[row-1][col] == charToMatch &&
            dfs(row-1, col, indexAt+1);

        final var right = isValidCell(row, col+1) &&
            !visited[row][col+1] &&
            board[row][col+1] == charToMatch &&
            dfs(row, col+1, indexAt+1);
        
        final var down = isValidCell(row+1, col) &&
            !visited[row+1][col] &&
            board[row+1][col] == charToMatch &&
            dfs(row+1, col, indexAt+1);

    
        final var left = isValidCell(row, col-1) &&
            !visited[row][col-1] &&
            board[row][col-1] == charToMatch &&
            dfs(row, col-1, indexAt+1);
        

        visited[row][col] = false;
        return up || right || down || left;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

}
