class Solution {
    private final static int IN_PROGRESS = -1;
    private final static int UNVISITED = 0;
    private final static int VISITED = 1;
    
    private int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.visited = new int[numCourses];

        final var graph = getGraph(numCourses, prerequisites);

        for (var i = 0; i < numCourses; i++) {
            if (!dfs(i, graph)) {
                return false;
            }
        }

        return true;
    }


    private boolean dfs(int course, Map<Integer, List<Integer>> graph) {

        visited[course] = IN_PROGRESS;

        final var prereqs = graph.getOrDefault(course, List.of());
        for (var nei : prereqs) {
            if (visited[nei] == VISITED) {
                continue;
            } else if (visited[nei] == IN_PROGRESS) {
                return false;
            }

            if (!dfs(nei, graph)) {
                return false;
            }
        }



        visited[course] = VISITED;
        return true;
    }

    private Map<Integer, List<Integer>> getGraph(int numCourses, int[][] prereqs) {
        final var result = new HashMap<Integer, List<Integer>>();

        for (var i = 0; i < numCourses; i++) {
            result.put(i, new ArrayList<Integer>());
        }

        for (var req : prereqs) {
            result.get(req[0]).add(req[1]);
        }

        return result;
    }
}
