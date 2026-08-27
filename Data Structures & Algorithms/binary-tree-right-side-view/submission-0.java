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
    class Tuple {
        int level;
        TreeNode node;
        Tuple(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, TreeNode> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        if (root == null) return result;

        q.add(new Tuple(0, root));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int level = t.level;

            map.put(level, node);

            if (node.left != null) q.add(new Tuple(level+1, node.left));
            if (node.right != null) q.add(new Tuple(level+1, node.right));
        }

        for (TreeNode node: map.values()) {
            result.add(node.val);
        }
        return result;

    }
}
