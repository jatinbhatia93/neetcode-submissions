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

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }
        Stack<TreeNode> stck = new Stack<>();
        stck.add(root);

        while (!stck.isEmpty()) {
            TreeNode node = stck.pop();
            if (node.val == subRoot.val) {
                if (isSameTree(node, subRoot)) {
                    return true;
                }
            }

            if (node.left != null) {
                stck.push(node.left);
            }
            if (node.right != null) {
                stck.push(node.right);
            }
        }
        return false;
    }

    private boolean isSameTree (TreeNode node, TreeNode sbNode) {
        if (node == null && sbNode == null) {
            return true;
        }
        if ((node == null && sbNode != null) || (node != null && sbNode == null) ) {
            return false;
        }

        if (node.val != sbNode.val) {
            return false;
        }
        if (!isSameTree(node.left, sbNode.left)) return false;
        if (!isSameTree(node.right, sbNode.right)) return false;
        return true;
    }
}
