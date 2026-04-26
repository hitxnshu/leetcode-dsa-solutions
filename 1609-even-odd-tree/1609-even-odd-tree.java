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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return false;
        }
        q.offer(root);
        int j = 0;
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
                int x = q.poll().val;
                if(list.size()!=0){
                    if(j % 2 == 0 || j == 0){
                        if(x % 2 == 0 || x <= list.get(list.size()-1)){
                            return false;
                        }
                        else{
                            list.add(x);
                        }
                    }
                    else{
                        if(x % 2 != 0 || x >= list.get(list.size()-1)){
                            return false;
                        }
                        else{
                            list.add(x);
                        }
                    }
                }
                else{
                    if(j % 2 == 0 || j == 0){
                        if(x % 2 == 0){
                            return false;
                        }
                        else{
                            list.add(x);
                        }
                    }
                    else{
                        if(x % 2 != 0){
                            return false;
                        }
                        else{
                            list.add(x);
                        }
                    }
                }
            }
            j++;
        }
        return true;
    }
}