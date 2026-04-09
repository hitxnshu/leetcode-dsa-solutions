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
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        if(root == null){
            return 0;
        }
        int sum = 0;
        while(q.isEmpty()!=true){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < size;i++){
                if(q.peek().val % 2 == 0){
                    if(q.peek().left!=null){
                        if(q.peek().left.left!=null){
                            sum = sum + q.peek().left.left.val;
                        }
                        if(q.peek().left.right!=null){
                            sum = sum + q.peek().left.right.val;
                        }
                    }
                    if(q.peek().right!=null){
                        if(q.peek().right.left!=null){
                            sum = sum + q.peek().right.left.val;
                        }
                        if(q.peek().right.right!=null){
                            sum = sum + q.peek().right.right.val;
                        }
                    }

                }
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                list.add(q.poll().val);
            }
        }
        return sum;
    }
}