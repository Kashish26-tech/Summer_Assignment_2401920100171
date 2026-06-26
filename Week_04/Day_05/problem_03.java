//Serialize and deserialize BT

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>();

        for (String s : arr) {
            q.offer(s);
        }

        return buildTree(q);
    }
    private TreeNode buildTree(Queue<String> q) {
        String val = q.poll();

        if (val.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = buildTree(q);
        root.right = buildTree(q);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
