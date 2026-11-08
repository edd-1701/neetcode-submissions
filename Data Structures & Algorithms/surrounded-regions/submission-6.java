class Solution {
    private final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int ROWS;
    private int COLS;
    private boolean[][] visited;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        // top/bottom rows
        for (var col = 0; col < COLS; col++) {
            if (board[0][col] == 'O' && !visited[0][col]) {
                bfs(0, col, board);
            }

            if (board[ROWS - 1][col] == 'O' && !visited[ROWS - 1][col]) {
                bfs(ROWS - 1, col, board);
            }
        }

        for (var row = 0; row < ROWS; row++) {
            if (board[row][0] == 'O' && !visited[row][0]) {
                bfs(row, 0, board);
            }

            if (board[row][COLS - 1] == 'O' && !visited[row][COLS - 1]) {
                bfs(row, COLS - 1, board);
            }
        }

        for (var r = 0; r < ROWS; r++) {
            for (var c = 0; c < COLS; c++) {
                if (board[r][c] == 'O' && !visited[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }

    }

    private void bfs(int row, int col, char[][] board) {
        final var queue = new ArrayDeque<int[]>();
        queue.addLast(new int[] {row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            final var curr = queue.pollFirst();

            for (var dir : DIRECTIONS) {
                final var r = curr[0] + dir[0];
                final var c = curr[1] + dir[1];

                if (r < 0 || r == ROWS || c < 0 || c == COLS || board[r][c] == 'X'
                    || visited[r][c]) {
                    continue;
                }

                queue.addLast(new int[] {r, c});
                visited[r][c] = true;
            }
        }
    }
}
