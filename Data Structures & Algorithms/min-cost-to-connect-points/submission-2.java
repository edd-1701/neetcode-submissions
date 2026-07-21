class Solution {
    public int minCostConnectPoints(int[][] points) {
        final var N = points.length;
        
        final var dist = new int[N];
        final var visited = new boolean[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        var currNode = 0;
        var result = 0;
        var connections = 0;
        while (connections < N - 1) {
            visited[currNode] = true;
            var nextNode = -1;

            for (var i = 0; i < N; i++) {
                if (visited[i]) {
                    continue;
                }
                final var currDist = getManhattanDist(points[currNode], points[i]);
                dist[i] = Math.min(dist[i], currDist);
                if (nextNode == -1 || dist[i] < dist[nextNode]) {
                    nextNode = i;
                }
            }

            result += dist[nextNode];
            currNode = nextNode;
            connections += 1;
        }

        return result;
    }

    private static int getManhattanDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }


}
