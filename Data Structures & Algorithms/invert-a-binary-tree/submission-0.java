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
    public TreeNode invertTree(TreeNode root) {
        TreeNode tempRoot = root;
        TreeNode node = root;
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return root;
        }
        q.add(node);
        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i<size; i++) {
                TreeNode temp = q.poll();

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                
                TreeNode swapNode = temp.left;
                temp.left = temp.right;
                temp.right = swapNode;
            }
        }
        return root;        
    }
}
