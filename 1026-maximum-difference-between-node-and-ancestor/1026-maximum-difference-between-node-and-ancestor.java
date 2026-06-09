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
    public void helper(TreeNode root, List<Integer> list,int[] ans){
        if(root == null){
            return;
        }
        if(list.size() == 0){
            list.add(root.val);
        }
        else{
            for(int i = 0;i < list.size();i++){
                int num = list.get(i);
                int temp = Math.abs(num - root.val);
                if(temp > ans[0]){
                ans[0] = temp;
            }
            }
            list.add(root.val);
        }
        helper(root.left,list,ans);
        helper(root.right,list,ans);
        list.remove(list.size()-1);
    }
    public int maxAncestorDiff(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        helper(root,list,ans);
        return ans[0];
    }
}