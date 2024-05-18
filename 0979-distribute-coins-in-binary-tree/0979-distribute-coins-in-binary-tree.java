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
    
    private int moves;
    
    public int distributeCoins(TreeNode root) {
        
        moves = 0;
        postOrderTraversal(root);
        return moves;
    }
    
    private int postOrderTraversal(TreeNode node){
        if(node == null) return 0;
        
        int leftBalance = postOrderTraversal(node.left);
        int rightBalance = postOrderTraversal(node.right);
        
        moves = moves + Math.abs(leftBalance) + Math.abs(rightBalance);
        
        return node.val + leftBalance + rightBalance - 1;
    }
}