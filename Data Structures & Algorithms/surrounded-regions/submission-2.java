/*

Iterate the borders (first/last row/column):
    if cell is O
        perform DFS and track all reachable Os, store in a hashmap
    
iterate board:
    if cell not in reachable Os, then flip to 'X'


safe = {}
visited = []
for dfs(row, col):
    if [row,col] not valid or visited or is 'X'
        return
    
    visited.add[row,col]
    safe{row,col}

    dfs()
    dfs()
    dfs()
    dfs()

    visited.remove[row,col]

*/

class Solution {
    private char[][] board;
    private int ROWS;
    private int COLS;
    private boolean[][] visited;
    private Map<Integer, Set<Integer>> reachable = new HashMap<>();

    public void solve(char[][] board) {
        this.board = board;
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for (var col = 0; col < COLS; col++) {
            if (board[0][col] == 'O' ) {
                dfs(0, col);
            }

            if (board[ROWS - 1][col] == 'O' ) {
                dfs(ROWS - 1, col);
            }
        }
        for (var row = 0; row < ROWS; row++) {
            if (board[row][0] == 'O' ) {
                dfs(row, 0);
            }

            if (board[row][COLS - 1] == 'O' ) {
                dfs(row, COLS - 1);
            }
        }

        for (var row = 0; row < ROWS; row++) {
            for (var col = 0; col < COLS; col++) {
                final var isSafe = reachable.containsKey(row) && reachable.get(row).contains(col);
                if (board[row][col] == 'O' && !isSafe) {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int col) {
        if (!isValid(row, col) || visited[row][col] || board[row][col] == 'X') {
            return;
        }

        visited[row][col] = true;
        reachable.computeIfAbsent(row, k -> new HashSet<>()).add(col);

        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);

        visited[row][col] = false;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }
}
