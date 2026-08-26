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
    public int maxDepth(TreeNode root) {
        int result = preOrderTraversal(root, 0);
        return result;
    }

    private int preOrderTraversal(TreeNode node, int result) {
        if (node == null) return result;
        result++;

        int leftDepth = Math.max(result, preOrderTraversal(node.left, result));
        int rightDepth = Math.max(result, preOrderTraversal(node.right, result));
        return Math.max(result, Math.max(leftDepth, rightDepth));
    }
}
