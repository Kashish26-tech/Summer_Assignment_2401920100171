//diameter of binary tree

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
    static class Info {
        int diam;
        int height;
        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }
    private Info diameterInfo(TreeNode root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info left = diameterInfo(root.left);
        Info right = diameterInfo(root.right);

        int height = Math.max(left.height, right.height) + 1;
        int diam = Math.max(Math.max(left.diam, right.diam), left.height+right.height);

        return new Info(diam, height);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterInfo(root).diam;
    }

}
