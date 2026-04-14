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
    public void helper(TreeNode root, Queue<TreeNode> q){
        if(root == null){
            return;
        }
        q.offer(root);
        helper(root.left,q);
        helper(root.right,q);
    }
    public void flatten(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        helper(root,q);
        q.poll();
        while(q.isEmpty()!=true){
            TreeNode a = q.poll();
            root.right = a;
            root.left = null;
            root = root.right;
        }
    }
}