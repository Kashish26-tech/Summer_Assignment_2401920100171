//Binary tree max path sum

class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        maxSum = Math.max(maxSum, node.val + leftGain + rightGain);

        return node.val + Math.max(leftGain, rightGain);
    }
}

