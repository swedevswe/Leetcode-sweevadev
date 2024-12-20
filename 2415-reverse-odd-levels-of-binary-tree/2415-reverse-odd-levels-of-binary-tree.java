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
    public TreeNode reverseOddLevels(TreeNode root) {
       //reverse the node values of 1, 3, 5, 7, 9 etc. levels, swap at the same level.
        //odd levels only
        //perfect binary tree = all nodes filled equally at every level.
        //BFS with queue - isolate odd levels.
    if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(level % 2 == 1){
                int left = 0, right = currentLevelNodes.size() - 1;
                while(left < right){
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}