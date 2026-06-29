/*
    Turn the courses into a graph
    The shape would be Map<CourseId, List<PrereqId>>

    iterate through all the courses:
        call a hasCycle for the current course
            if cycle -> we can't finish these courses
        
    return true if we iterated through all


    we need a visited array to track already seen per dfs call
    also need a call stack array, to see how deep we are
    call a dfs function starting at course 0

    dfs(id)

        if (id in visited)
            we have traveled all the way around for this course
            return false (valid course order)            

        if (id in the stack)
            we have a cycle
            return true (cycle)

        add course to visited
        add course from stack

        foreach neigh:
            dfs(neigh)
        
        remove course from visited

*/
class Solution {
    private Map<Integer, List<Integer>> graph;
    private boolean[] visited;
    private boolean[] stack;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        stack = new boolean[numCourses];

        for (var course = 0; course < numCourses; course++) {
            if (hasCycle(course)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int courseId) {
        if (stack[courseId]) {
            return true;
        }

        if (visited[courseId]) {
            return false;
        }

        visited[courseId] = true;
        stack[courseId] = true;

        final var neighbors = graph.get(courseId);
        for (var neigh : neighbors) {
            if (hasCycle(neigh)) {
                return true;
            }
        }

        stack[courseId] = false;

        return false;
    }

    private Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] reqs) {
        final var result = new HashMap<Integer, List<Integer>>();

        for (var i = 0; i < numCourses; i++) {
            result.put(i, new ArrayList<Integer>());
        }

        for (var req : reqs) {
            result.get(req[0]).add(req[1]);
        }

        return result;
    }
}
