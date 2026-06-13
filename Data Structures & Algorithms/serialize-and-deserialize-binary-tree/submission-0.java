/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    private final static String NULL_SYMBOL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        final var response = new ArrayList<String>();
        serializeHelper(root, response);
        return String.join(",", response);
    }

    private void serializeHelper(TreeNode node, List<String> res) {
        if (node == null) {
            res.add(NULL_SYMBOL);
            return;
        }

        res.add(String.valueOf(node.val));
        serializeHelper(node.left, res);
        serializeHelper(node.right, res);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        final var splitData = data.split(",");
        final var indexAt = new AtomicInteger(0);
        return deserializeHelper(splitData, indexAt);
    }

    private TreeNode deserializeHelper(String[] data, AtomicInteger indexAt) {
        if (NULL_SYMBOL.equals(data[indexAt.get()])) {
            indexAt.incrementAndGet();
            return null;
        }

        final var numericVal = Integer.parseInt(data[indexAt.getAndIncrement()]);
        final var node = new TreeNode(numericVal);
        node.left = deserializeHelper(data, indexAt);
        node.right = deserializeHelper(data, indexAt);
        return node;
    }


}
