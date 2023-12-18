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
    List<TreeNode> list = new ArrayList<>();
    public int closestValue(TreeNode root, double target) {

        int closest = root.val;
        TreeNode currentNode = root;

        while(currentNode != null) {
            if(Math.abs(target-closest) == Math.abs(target-currentNode.val) && closest > currentNode.val) closest = currentNode.val;
            else if(Math.abs(target-closest) > Math.abs(target-currentNode.val)) closest = currentNode.val;


            if(currentNode.val >= target) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }

        return closest;
        
    }

}
