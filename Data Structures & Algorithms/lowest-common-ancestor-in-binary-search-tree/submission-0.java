/*

if p == q, then return p

use a helper function that tracks the path until I reach a specific target node
then I compare teh paths for both to find the last matching value


*/

class Solution {
    private int pVal;
    private int qVal;
    private List<TreeNode> pPath = new ArrayList<>();
    private List<TreeNode> qPath = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == q.val) {
            return p;
        }

        pVal = p.val;
        qVal = q.val;

        traverse(root, new ArrayList<>());

        // System.out.println("path to p: %s, path to q: %s".formatted(
        //     pPath, qPath
        // ));

        //(mxn) operation
        pPath.retainAll(qPath);

        return pPath.getLast();
        
    }
    
    private void traverse(TreeNode node, List<TreeNode> path) {
        if (node == null || (!pPath.isEmpty() && !qPath.isEmpty())) {
            return;
        }


        path.add(node);

        if (node.val == pVal) {
            pPath = new ArrayList<>(path);
        }

       if (node.val == qVal) {
            qPath = new ArrayList<>(path);
        }

        final var pathLen = path.size();
        // final var pathCopy = new ArrayList<>(path);
        traverse(node.left, path);

        path.subList(pathLen, path.size()).clear();
        traverse(node.right, path);
    }
}
