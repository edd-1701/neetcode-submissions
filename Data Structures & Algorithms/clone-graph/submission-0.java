class Solution {
    private Map<Integer, Node> cloneMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        return cloneNode(node);
    }

    private Node cloneNode(Node node) {
        if (node == null) {
            return null;
        }

        final var cloneObj = new Node(node.val);
        cloneMap.put(node.val, cloneObj);

        for (var neigh : node.neighbors) {
            if (!cloneMap.containsKey(neigh.val)) {
                cloneObj.neighbors.add(cloneNode(neigh));
            } else {
                cloneObj.neighbors.add(cloneMap.get(neigh.val));
            }
            
        }

        
        return cloneObj;
    }
}