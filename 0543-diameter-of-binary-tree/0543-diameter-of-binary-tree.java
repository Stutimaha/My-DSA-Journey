class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        
        int[] diameter = new int[1];
        calculateHeight(root, diameter);
        return diameter[0] - 1;
    }

    private int calculateHeight(TreeNode node, int[] diameter) {
        if (node == null)
            return 0;
        
        int leftHeight = calculateHeight(node.left, diameter);
        int rightHeight = calculateHeight(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
