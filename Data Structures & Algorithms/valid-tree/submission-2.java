class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length > n - 1) {
            return false;
        }

        final var adj = buildGraph(n, edges);

        final var visited = new HashSet<Integer>();
        if (hasCycle(0, -1, adj, visited)) {
            return false;
        }

        return visited.size() == n;
    }

    private boolean hasCycle(int node, int parent, List<List<Integer>> adj, Set<Integer> visited) {
        if (visited.contains(node)) {
            return true;
        }

        visited.add(node);
        for (var nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }

            if (hasCycle(nei, node, adj, visited)) {
                return true;
            }
        }

        return false;
    }



    private List<List<Integer>> buildGraph(int n, int[][] adj) {
        final var result = new ArrayList<List<Integer>>();

        for (var i = 0; i < n; i++) {
            result.add(new ArrayList<Integer>());
        }

        for (var edge : adj) {
            result.get(edge[0]).add(edge[1]);
            result.get(edge[1]).add(edge[0]);
        }

        return result;
    }
}
