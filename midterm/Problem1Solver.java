package midterm;

public class Problem1Solver {

    public TreeNode flipBinaryTree(TreeNode currentNode) {
        if (currentNode == null || currentNode.left == null) {
            return currentNode;
        }

        TreeNode flippedRoot = flipBinaryTree(currentNode.left);

        currentNode.left.left = currentNode.right; // Swap the right child
        currentNode.left.right = currentNode; // Make current node a right child

        // Detach current node from its children
        currentNode.left = null;
        currentNode.right = null;

        return flippedRoot; // Return the new root of the flipped tree
    }

    public void displayTree(TreeNode node) {
        if (node != null) {
            displayTree(node.left); // First, visit the left subtree
            System.out.print(node.val + " "); // Then, print the node's value
            displayTree(node.right); // Lastly, visit the right subtree
        }
    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode(1); // Root node
        treeRoot.left = new TreeNode(2);
        treeRoot.right = new TreeNode(3);
        treeRoot.left.left = new TreeNode(4);
        treeRoot.left.right = new TreeNode(5);

        Problem1Solver solver = new Problem1Solver();
        TreeNode modifiedRoot = solver.flipBinaryTree(treeRoot);

        solver.displayTree(modifiedRoot); // Print the modified tree
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int value) { val = value; }
}
