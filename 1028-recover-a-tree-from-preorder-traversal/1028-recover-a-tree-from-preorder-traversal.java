class Solution {
    private int idx = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        return recover(traversal, 0);
    }

    private TreeNode recover(String traversal, int depth) {
        int numDashes = 0;
        while (idx + numDashes < traversal.length() && traversal.charAt(idx + numDashes) == '-') {
            numDashes++;
        }

        if (numDashes != depth) {
            return null;
        }

        idx += numDashes;
        int value = 0;
        while (idx < traversal.length() && Character.isDigit(traversal.charAt(idx))) {
            value = value * 10 + (traversal.charAt(idx) - '0');
            idx++;
        }

        TreeNode node = new TreeNode(value);
        node.left = recover(traversal, depth + 1);
        node.right = recover(traversal, depth + 1);
        return node;
    }
}
