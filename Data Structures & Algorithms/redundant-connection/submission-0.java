class Solution {
    private Set<Integer> cycleNodes = new HashSet<>();
    private int cycleStartNode = -1;
    private boolean[] visited;

    public int[] findRedundantConnection(int[][] edges) {
        final var MAX_NODE = edges.length;
        final var graph = buildGraph(edges);

        visited = new boolean[MAX_NODE + 1];

        hasCycleDfs(1, -1, graph);

        for (var i = edges.length - 1; i >= 0; i--) {
            if (cycleNodes.contains(edges[i][0]) && cycleNodes.contains(edges[i][1])) {
                return edges[i];
            }
        }

        return new int[0];
    }

    private boolean hasCycleDfs(int node, int parent, List<List<Integer>> graph) {
        if (visited[node]) {
            cycleStartNode = node;
            return true;
        }

        visited[node] = true;
        for (var nei : graph.get(node)) {
            if (nei == parent) {
                continue;
            }

            if (hasCycleDfs(nei, node, graph)) {
                if (cycleStartNode != -1) {
                    cycleNodes.add(node);
                }

                if (node == cycleStartNode) {
                    cycleStartNode = -1;
                }
                return true;
            }
        }

        return false;
    }

    private List<List<Integer>> buildGraph(int[][] edges) {
        final var result = new ArrayList<List<Integer>>();
        for (var i = 0; i <= edges.length; i++) {
            result.add(new ArrayList<Integer>());
        }
        for (var conn : edges) {
            result.get(conn[0]).add(conn[1]);
            result.get(conn[1]).add(conn[0]);
        }
        return result;
    }
}
