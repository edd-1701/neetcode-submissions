class Solution {
    private Map<Integer, Node> mapping = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        return deepCopy(node);
    }

    private Node deepCopy(Node node) {
        if (mapping.containsKey(node.val)) {
            return mapping.get(node.val);
        }

        final var copyNode = new Node(node.val);
        mapping.put(node.val, copyNode);

        for (var nei : node.neighbors) {
            if (mapping.containsKey(nei.val)) {
                copyNode.neighbors.add(mapping.get(nei.val));
            } else {
                copyNode.neighbors.add(deepCopy(nei));
            }
        }

        return copyNode;
    }
}