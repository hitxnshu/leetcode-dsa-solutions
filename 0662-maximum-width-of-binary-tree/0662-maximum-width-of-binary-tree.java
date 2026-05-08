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
 class Pair<K,V>{
    private K key;
    private V value;
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        if(root == null){
            return 0;
        }
        q.offer(new Pair<>(root,0));
        int ans = 0;
        while(q.isEmpty()!=true){
            int size = q.size();
            int mmin = q.peek().getValue();
            int first = 0,last = 0;
            for(int i = 0;i < size;i++){
                int curr_i = q.peek().getValue() - mmin;
                TreeNode node = q.peek().getKey();
                q.poll();
                if(i == 0)
                first = curr_i;
                if(i == size-1)
                last = curr_i;
                if(node.left!=null){
                    q.offer(new Pair<>(node.left,(curr_i * 2) + 1));
                }
                if(node.right!=null){
                    q.offer(new Pair<>(node.right,(curr_i * 2) + 2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
}