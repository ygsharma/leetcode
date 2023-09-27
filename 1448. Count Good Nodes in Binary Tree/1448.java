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
    int count = 1;
    public int goodNodes(TreeNode root) {
        
        helper(root, root.val);
        return count;
    }

    public void helper(TreeNode root, int maxSoFar) {

        if(root == null) return;

        
        if(root.left != null) {
            if(maxSoFar <= root.left.val) {
                count++;
                helper(root.left, root.left.val);
            }
            else helper(root.left, maxSoFar);
        }

        if(root.right != null) {
            if(maxSoFar <= root.right.val) {
                count++;
                helper(root.right, root.right.val);
            }
            else helper(root.right, maxSoFar);
        }
    }
}
