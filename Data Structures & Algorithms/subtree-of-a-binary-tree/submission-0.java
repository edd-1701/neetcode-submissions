class Solution {
    private boolean foundSubtree = false;
    private List<Integer> targetList = new ArrayList<Integer>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //traverse tree
        //when matching root found, traverse from there


        listTree(subRoot, targetList);

        traverse(root);

        return foundSubtree;
    }


    private void traverse(TreeNode node) {
        if (node == null || foundSubtree) {
            return;
        }

        if (node.val == targetList.getFirst()) {
            final var candidateSubRootList = new ArrayList<Integer>();
            listTree(node, candidateSubRootList);

            if (targetList.equals(candidateSubRootList)) {
                foundSubtree = true;
                return;
            }
        }

        traverse(node.left);
        traverse(node.right);
    }


    private void listTree(TreeNode node, List<Integer> result) {

        result.add(node == null ? null : node.val);

        if (node == null) {
            return;
        }
        listTree(node.left, result);
        listTree(node.right, result);
    }
}
