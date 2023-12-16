/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/* Algorithm Used

Let us first define a function called height(node) which returns the height of the node.
The function can be implemented via recursion, based on the following formula:

height(root)=max⁡(height(child))+1, ∀child∈node.children\text{height(node)} = \max\big(\text{height(child)}\big) + 1, \space \forall \text{child} \in \text{node.children}height(node)=max(height(child))+1, ∀child∈node.children

More importantly, within the function of height(node), we need to select the top two largest heights of its children nodes.
With these top two largest heights, we calculate the length of the combined path, which would be the candidate as the diameter of the entire tree.

There are two ways to select the top two largest heights:

A straight-forward way would be that we keep the heights of all children nodes in an array, and then we sort the array and select the top two largest elements.

A constant-space solution would be that we use only two variables which keep track of the current top two largest elements respectively. While we iterate through all the heights, we update the two variables accordingly.
*/

class Solution {
    public int diameter = 0;
    public int diameter(Node root) {
        height(root);
        return diameter;
    }

    public int height(Node root) {
        if(root.children.size() == 0) return 0;

        int maxHeight1 = 0, maxHeight2 = 0;
        for(Node node : root.children) {
            int parentHeight = height(node) + 1;
            // update both 
            if(parentHeight > maxHeight1) {
                maxHeight2 = maxHeight1;
                maxHeight1 = parentHeight;
            }
            else if(parentHeight > maxHeight2) maxHeight2 = parentHeight;
            
            this.diameter = Math.max(diameter, maxHeight1 + maxHeight2);
        }
        return maxHeight1;
    }
}


