

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        final var graph = buildGraph(tickets);
        final var result = new ArrayList<String>();
        dfs("JFK", graph, result);
        return result.reversed();
        // return result;
    }

    private void dfs(String code, Map<String, PriorityQueue<String>> graph, List<String> result) {
        final var queue = graph.get(code);

        while (queue != null && !queue.isEmpty()) {
            final var next = queue.poll();
            dfs(next, graph, result);
        }

        result.add(code);
    }

    private static Map<String, PriorityQueue<String>> buildGraph(List <List<String>> tickets) {
        final var result = new HashMap<String, PriorityQueue<String>>();
    
        for (var ticket : tickets) {
            result.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<String>()).offer(ticket.get(1));
        }
        return result;
    }
}
