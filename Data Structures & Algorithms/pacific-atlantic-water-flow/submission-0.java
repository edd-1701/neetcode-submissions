/*
top row    , left col  -> pacific
botton row , right col -> atlantic

create a set for each ocean, we will track the cells that we can visit
also need a visited

*/

record Cell(int row, int col){};
class Solution {
    private int[][] grid;
    private int ROWS;
    private int COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.grid = heights;
        ROWS = heights.length;
        COLS = heights[0].length;

        final var pacificReachable = new HashSet<Cell>();
        final var pacificVisited = new boolean[ROWS][COLS];
        for (var col = 0; col < COLS; col++) {
            dfs(0, col, 0, pacificReachable, pacificVisited);
        }
        for (var row = 0; row < ROWS; row++) {
            dfs(row, 0, 0, pacificReachable, pacificVisited);
        }

        final var atlanticReachable = new HashSet<Cell>();
        final var atlanticVisited = new boolean[ROWS][COLS];
        for (var col = 0; col < COLS; col++) {
            dfs(ROWS - 1, col, 0, atlanticReachable, atlanticVisited);
        }
        for (var row = 0; row < ROWS; row++) {
            dfs(row, COLS - 1, 0, atlanticReachable, atlanticVisited);
        }

        pacificReachable.retainAll(atlanticReachable);
        final var result = new ArrayList<List<Integer>>();
        for (var cell : pacificReachable) {
            result.add(List.of(cell.row, cell.col));
        }

        return result;
    }


    public void dfs(int row, int col, int parentHeight, Set<Cell> reachable, boolean[][] visited) {
        if (!isValid(row,col) || visited[row][col] || parentHeight > grid[row][col]) {
            return;
        }

        visited[row][col] = true;
        reachable.add(new Cell(row, col));

        final var height = grid[row][col];
        dfs(row + 1, col, height, reachable, visited);
        dfs(row - 1, col, height, reachable, visited);
        dfs(row, col + 1, height, reachable, visited);
        dfs(row, col - 1, height, reachable, visited);

    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }
}
