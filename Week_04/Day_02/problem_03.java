//Binary tree zigzag level order traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        boolean reverse = false;

        while(!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int level = q.size();

            for(int i=0; i<level; i++) {
                if(!reverse) {
                    TreeNode curr = q.removeFirst();
                    temp.add(curr.val);

                    if(curr.left != null) {
                        q.addLast(curr.left);
                    }
                    if(curr.right != null) {
                        q.addLast(curr.right);
                    }
                }
                else {
                    TreeNode curr = q.removeLast();
                    temp.add(curr.val);

                    if(curr.right != null) {
                        q.addFirst(curr.right);
                    }
                    if(curr.left != null) {
                        q.addFirst(curr.left);
                    }
                }
            }
            result.add(temp);
            reverse = !reverse;
        }
        return result;
        
    }
}
