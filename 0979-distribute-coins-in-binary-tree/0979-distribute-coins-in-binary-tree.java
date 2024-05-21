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
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        postOrder(root);
        return moves;
    
        
    }
    private int postOrder(TreeNode node){
        if(node==null) return 0;
        int leftBalance = postOrder(node.left);
        int rightBalance = postOrder(node.right);
        
        moves += Math.abs(leftBalance) + Math.abs(rightBalance);
        
        return node.val + leftBalance + rightBalance - 1;
        }
}