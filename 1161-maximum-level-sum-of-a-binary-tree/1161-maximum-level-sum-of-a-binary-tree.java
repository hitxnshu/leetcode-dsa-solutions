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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return 0;
        }
        q.offer(root);
        HashMap<Integer,Integer> map = new HashMap<>();
        int j = 1;
        while(q.isEmpty()!=true){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i = 0;i < size;i++){
                if(q.peek().left!=null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right!=null){
                    q.offer(q.peek().right);
                }
                list.add(q.poll().val);
            }
            int sum = 0;
            for(int k = 0;k < list.size();k++){
                sum += list.get(k);
            }
            map.put(j,sum);
            j++;
        }
        int maxo = Integer.MIN_VALUE;
        for(int i : map.keySet()){
            if(map.get(i) > maxo){
                maxo = map.get(i);
            }
        }
        List<Integer> temp = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i) == maxo){
                temp.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < temp.size();i++){
            if(temp.get(i) < min){
                min = temp.get(i);
            }
        }
        return min;
    }
}