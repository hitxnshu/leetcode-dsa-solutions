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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.offer(root);
        if(root == null){
            return ans;
        }
        int j = 1;
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
            if(j%2==0){
                Collections.reverse(list);
            }
            j++;
            ans.add(list);
        }
        return ans;
    }
}