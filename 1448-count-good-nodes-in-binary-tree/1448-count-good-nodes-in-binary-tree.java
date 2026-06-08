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
    public void helper(TreeNode root,List<Integer> list,int[] count){
        if(root == null){
            return;
        }
        list.add(root.val);
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < list.size();i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        if(list.get(list.size()-1) == max){
            count[0]++;
        }
        helper(root.left,list,count);
        helper(root.right,list,count);
        list.remove(list.size()-1);
        return;

    }
    public int goodNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[1];
        helper(root,list,count);
        return count[0];
    }
}