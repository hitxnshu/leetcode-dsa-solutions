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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        helper1(root1,list1);
        helper2(root2,list2);
        List<Integer> ans = new ArrayList<>();
        int a = 0;
        int b = 0;
        while(a != list1.size() && b != list2.size()){
            if(list1.get(a) > list2.get(b)){
                ans.add(list2.get(b));
                b++;
            }
            else{
                ans.add(list1.get(a));
                a++;
            }
        }
        for(int i = a;i < list1.size();i++){
            ans.add(list1.get(i));
        }
        for(int i = b;i < list2.size();i++){
            ans.add(list2.get(i));
        }
        return ans;
    }
    public void helper1(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        helper1(root.left,list);
        list.add(root.val);
        helper1(root.right,list);
    }
    public void helper2(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        helper2(root.left,list);
        list.add(root.val);
        helper2(root.right,list);
    }
}