package midterm;

public class Problem2Solver {

    // Count of uni-value subtrees found
    private int univalSubtreeCount = 0;

    /**
     * Initiates the process to find uni-value subtrees within the given binary tree.
     * 
     * @param rootNode The root node of the binary tree.
     * @return The total count of uni-value subtrees.
     */
    public int findUnivalSubtrees(TreeNode rootNode) {
        // Use a sentinel value since the actual root value can be anything within int range
        checkUnival(rootNode, -1001);
        return univalSubtreeCount;
    }

    /**
     * Checks if the subtree rooted at the given node is a uni-value subtree.
     * 
     * @param current The current node being checked.
     * @param parentValue The value of the parent node, used to determine if the current subtree is uni-value.
     * @return True if the subtree is uni-value, false otherwise.
     */
    private boolean checkUnival(TreeNode current, int parentValue) {
        // Base case: An empty subtree is considered uni-value.
        if (current == null) return true;

        // Recursively check if the left and right subtrees are uni-value.
        boolean isLeftUnival = checkUnival(current.left, current.val);
        boolean isRightUnival = checkUnival(current.right, current.val);

        // If either the left or right subtree is not uni-value, the current subtree cannot be uni-value.
        if (!isLeftUnival || !isRightUnival) return false;

        // Increment the count of uni-value subtrees.
        univalSubtreeCount++;

        // Return true if the current node matches the parent node's value, indicating a continuation of a uni-value subtree.
        return current.val == parentValue;
    }

    public static void main(String[] args) {
        // Example binary tree construction
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        // Creating an instance of Problem2Solver to find uni-value subtrees.
        Problem2Solver solver = new Problem2Solver();
        int totalUnivalSubtrees = solver.findUnivalSubtrees(root);

        // Output the count of uni-value subtrees found.
        System.out.println("Total uni-value subtrees: " + totalUnivalSubtrees);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int value) {
        val = value;
    }
}
