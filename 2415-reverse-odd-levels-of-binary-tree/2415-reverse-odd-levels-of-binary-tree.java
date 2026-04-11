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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        if(root == null){
            return null;
        }
        int x = 0;
        while(q.isEmpty()!=true){
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            for(int i = 0;i < size;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                list.add(q.poll());
            }
            if(x%2!=0){
            for(int i = 0;i < list.size()/2;i++){//loop only goes till half size as we are including second half in first half only
                int a = list.get(i).val;
                list.get(i).val = list.get(list.size()-1-i).val;
                list.get(list.size()-i-1).val = a;
            }
            }
            x++;
        }
        return root;
    }
}