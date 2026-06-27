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
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        sort(list);
        int[] i = new int[1];
        inorderAgain(root,list,i);
    }
    public void inorder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public void sort(List<Integer> list){
        for(int i = 0;i < list.size();i++){
            for(int j = i+1;j < list.size();j++){
                if(list.get(i) > list.get(j)){
                    int temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
    }
    public void inorderAgain(TreeNode root,List<Integer> list,int[] i){
        if(root == null){
            return;
        }
        inorderAgain(root.left,list,i);
        if(root.val != list.get(i[0])){
            root.val = list.get(i[0]);
        }
        i[0]++;
        inorderAgain(root.right,list,i);
    }
    // public TreeNode preToTree(List<Integer> list){
    //     TreeNode origRoot = list.get(0);
    //     TreeNode root = origRoot;
    //     Stack<TreeNode> st = new Stack<>();
    //     st.push(root);
    //     TreeNode y = null;
    //     for(int i = 1;i < list.size();i++){
    //         if(list.get(i) < st.peek().val){
    //             TreeNode x = new TreeNode(list.get(i));
    //             root.left = x;
    //             root = root.left;
    //         }
    //         else{
    //             while(list.get(i) > st.peek().val){
    //                 y = st.pop();
    //             }
    //             TreeNode z = new TreeNode(list.get(i));
    //             y.next = z;
    //             z = root;
    //         }
    //     }
    //     return origRoot;
    // } 
}