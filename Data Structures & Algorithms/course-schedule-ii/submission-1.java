/*

Build adjancency list

visited = [n]
result = [n]
resultIndex = 0;
iterate through it 0..n-1:
    dfs(node):

        visited[n] = true

        foreach unvisited_nei:
            dfs(nei)

        result[resultIndex++] = node




*/
class Solution {
    private final static int STATE_UNVISITED = 0;
    private final static int STATE_TRAVERSING = 1;
    private final static int STATE_PROCESSED = 2;

    private final static int[] BLANK_RESPONSE = {};

    private int[] visited;
    private int[] result;
    private int resultIndex = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        result = new int[numCourses];

        final var graph = buildGraph(numCourses, prerequisites);
        for (var i = 0; i < numCourses; i++) {
            if (visited[i] == STATE_PROCESSED) {
                continue;
            }
            if (hasCycleDfs(i, graph)) {
                return BLANK_RESPONSE;
            }
            
        }

        return resultIndex == numCourses ? result : BLANK_RESPONSE;
    }

    private boolean hasCycleDfs(int course, Map<Integer, List<Integer>> graph) {

        if (visited[course] == STATE_TRAVERSING) {
            return true;
        }

        visited[course] = STATE_TRAVERSING;

        for (var nei : graph.get(course)) {
            if (visited[nei] == STATE_PROCESSED) {
                continue;                
            }
            if (hasCycleDfs(nei, graph)) {
                return true;
            }
        }

        result[resultIndex++] = course;
        visited[course] = STATE_PROCESSED;
        return false;
    }



    private Map<Integer, List<Integer>> buildGraph(int courses, int[][] prereqs) {
        final var result = new HashMap<Integer, List<Integer>>();
        for (var i = 0; i < courses; i++) {
            result.put(i, new ArrayList<Integer>());
        }
        for (var req : prereqs) {
            result.get(req[0]).add(req[1]);
        }
        return result;
    }

}
