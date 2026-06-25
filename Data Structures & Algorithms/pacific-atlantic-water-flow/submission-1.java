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

        final var pacificReachable = new HashMap<Integer, Set<Integer>>();
        final var pacificVisited = new boolean[ROWS][COLS];
        for (var col = 0; col < COLS; col++) {
            dfs(0, col, 0, pacificReachable, pacificVisited);
        }
        for (var row = 0; row < ROWS; row++) {
            dfs(row, 0, 0, pacificReachable, pacificVisited);
        }

        final var atlanticReachable = new HashMap<Integer, Set<Integer>>();
        final var atlanticVisited = new boolean[ROWS][COLS];
        for (var col = 0; col < COLS; col++) {
            dfs(ROWS - 1, col, 0, atlanticReachable, atlanticVisited);
        }
        for (var row = 0; row < ROWS; row++) {
            dfs(row, COLS - 1, 0, atlanticReachable, atlanticVisited);
        }

        final var result = new ArrayList<List<Integer>>();
        for (var entry : pacificReachable.entrySet()) {
            final var atl = atlanticReachable.get(entry.getKey());

            if (atl == null) {
                continue;
            }

            for (var col : entry.getValue()) {
                if (atl.contains(col)) {
                    result.add(List.of(entry.getKey(), col));
                }
            }
        }
        // for (var cell : pacificReachable) {
        //     result.add(List.of(cell.row, cell.col));
        // }

        return result;
    }


    public void dfs(int row, int col, int parentHeight, Map<Integer, Set<Integer>> reachable, boolean[][] visited) {
        if (!isValid(row,col) || visited[row][col] || parentHeight > grid[row][col]) {
            return;
        }

        visited[row][col] = true;
        reachable.computeIfAbsent(row, k -> new HashSet<Integer>()).add(col);

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
