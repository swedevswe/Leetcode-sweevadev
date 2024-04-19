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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        insert(root, val, 1, depth);
        return root;
    }
    private void insert(TreeNode node, int val, int currentDepth, int targetDepth){
        if(node==null){
            return;
        }
        if(currentDepth == targetDepth-1){
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            
            newLeft.left = node.left;
            newRight.right = node.right;
            
            node.left = newLeft;
            node.right = newRight;
        }
        else{
            insert(node.left, val, currentDepth + 1, targetDepth);
            insert(node.right, val, currentDepth + 1, targetDepth);
        }
    }
}