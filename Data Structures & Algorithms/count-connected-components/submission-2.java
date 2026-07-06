/*

    Build an adjancecy list
    birectional

    foreach node:
        if not visited, mark as a new component, then do a dfs to find all the connections
*/
class Solution {
    public int countComponents(int n, int[][] edges) {
        var count = 0;

        final var adj = buildGraph(n, edges);
        final var visited = new boolean[n];
        for (var i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            count += 1;
            if (adj.containsKey(i)) {
                dfs(i, visited, adj);
            }
        }

        return count;
    }

    private void dfs(int node, boolean[] visited, Map<Integer, List<Integer>> graph) {
        visited[node] = true;

        for (var nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, visited, graph);
            }
        }
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        final var result = new HashMap<Integer, List<Integer>>();
        for (var conn : edges) {
            result.computeIfAbsent(conn[0], k -> new ArrayList<Integer>()).add(conn[1]);
            result.computeIfAbsent(conn[1], k -> new ArrayList<Integer>()).add(conn[0]);
        }
        return result;
    }
}
