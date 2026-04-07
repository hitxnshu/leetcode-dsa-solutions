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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        q.offer(root);
        while(q.isEmpty()!=true){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < size;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                list.add(q.poll().val);
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0;i < list.size();i++){
                if(list.get(i) > max){
                    max = list.get(i);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}