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
    public boolean isValidBST(TreeNode root) {

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }

    // define range (min, max) in which the new node can lie
    // for root.left range = (-inf, root.val)
    // for root.right range = (root.val, inf)
    public boolean helper(TreeNode root, long min, long max) {

        if(root == null) return true;

        if(root.val >= max || root.val <= min) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
