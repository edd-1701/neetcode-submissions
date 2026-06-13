class Solution {

    private int preOrderIndex = 0;
    private Map<Integer, Integer> inOrderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {        
        for (var i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return helper(0, preorder.length - 1, preorder);
    }

    private TreeNode helper(int left, int right, int[] preorder) {
        if (left > right) {
            return null;
        }

        final var node = new TreeNode(preorder[preOrderIndex++]);

        final var inOrderIndex = inOrderMap.get(node.val);

        node.left = helper(left, inOrderIndex - 1, preorder);
        node.right = helper(inOrderIndex + 1, right, preorder);

        return node;
    }
}
