/*
Build a weighted directed graph connecting nodes


start a dfs from node n 
graph is directed so there's no risk of a cycle
on each n I update the current time 
*/

class Solution {
    private int[] travelTimes;
    private Map<Integer, List<int[]>> graph = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        graph = buildGraph(n, times);
        travelTimes = new int[n];
        Arrays.fill(travelTimes, Integer.MAX_VALUE);

        dfs(k, -1, 0);

        var max = Integer.MIN_VALUE;
        for (var time : travelTimes) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            }

            if (time > max) {
                max = time;
            }
        }

        return max;
    }


    private void dfs(int node, int parent, int currTime) {


        if (travelTimes[node - 1] <= currTime) {
            return;
        }

        travelTimes[node - 1] = currTime;

        final var neighbors = graph.get(node);

        if (neighbors == null) {
            return;
        }

        for (var nei : neighbors) {
            if (nei[0] == parent) {
                continue;
            }
            dfs(nei[0], node, currTime + nei[1]);
        }

    }

    private Map<Integer, List<int[]>> buildGraph(int n, int[][] times) {
        final var result = new HashMap<Integer, List<int[]>>();

        for (var rel : times) {
            result.computeIfAbsent(rel[0], k -> new ArrayList<int[]>()).add(new int[]{rel[1],rel[2]});
        }

        return result;
    }



}
