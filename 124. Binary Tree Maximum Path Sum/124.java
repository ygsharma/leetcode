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
    int maxSum;
    public int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    public int solve(TreeNode root) {

        if(root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        // 3 possible paths to get sum from:
        // Path 1: we get maxSum in loop inleft or right side of root
        // we can't return this bcoz this sum is coming converged loop
        int foundMaxInLoop = l + r + root.val;

        // Path2: we got maxSum from 1 of the sides and we aremoving up towards root: leftOrRightSumBetter
        // Path 3: l or r sum may be -ve, so take only root.val as maxSum and move upwards
        int leftOrRightSumBetter = Math.max(l, r) + root.val;
        int onlyRootVal = root.val;

        // update maxSum as max of all 3 paths and maxSum
        maxSum = Math.max(maxSum, Math.max(foundMaxInLoop, Math.max(leftOrRightSumBetter, onlyRootVal)));

        // finally return max of path2 and path3. we can't include path1 in the max due to above reason
        return Math.max(leftOrRightSumBetter, onlyRootVal);

    }
}
