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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lstd = diameterOfBinaryTree(root.left);
        int rstd = diameterOfBinaryTree(root.right);

        int ht = height(root.left) + height(root.right);

        return Math.max(ht, Math.max(lstd, rstd));
        
        // return optimizedDiameter(root).getKey()-1;
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(lh, rh) + 1;
    }

    public Pair<Integer, Integer> optimizedDiameter(TreeNode root){

        if(root == null){
            Pair p = new Pair(0,0);
            return p;
        }

        Pair left = optimizedDiameter(root.left);
        Pair right = optimizedDiameter(root.right);

        Integer op1 = (Integer)left.getKey();
        Integer op2 = (Integer)right.getKey();

        Integer op3 = (Integer)left.getValue() + (Integer)right.getValue() + 1;

        Integer diameter = Math.max(op1, Math.max(op2, op3));
        Integer height = Math.max((Integer)left.getValue(), (Integer)right.getValue()) + 1;

        return new Pair(diameter, height);
    }
}
