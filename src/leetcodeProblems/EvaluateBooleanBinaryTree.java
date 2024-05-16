package leetcodeProblems;

/**
 * @author Raian Rahman
 * @since 2024.0.0
 */
public class EvaluateBooleanBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean evaluateTree(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val == 1;
        }

        boolean left;
        boolean right;

        if (node.left != null) {
            left = evaluateTree(node.left);
        } else {
            left = node.val == 2;
        }

        if (node.right != null) {
            right = evaluateTree(node.right);
        } else {
            right = node.val == 2;
        }

        if (node.val == 2) {
            return left || right;
        } else {
            return left && right;
        }
    }
}
