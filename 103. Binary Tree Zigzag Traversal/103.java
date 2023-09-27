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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        boolean leftToRight = true;
        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();
            Integer[] ans = new Integer[size];
            
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();

                int idx = leftToRight ? i : size - i - 1;
                ans[idx] = node.val;

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

            }
            leftToRight = !leftToRight;
            result.add(Arrays.asList(ans));
        }

        return result;
    }
}
