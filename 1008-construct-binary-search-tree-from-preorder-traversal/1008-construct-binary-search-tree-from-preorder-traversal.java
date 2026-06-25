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
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode origRoot = new TreeNode(preorder[0]);
        TreeNode root = origRoot;
        st.push(root);
        TreeNode temp = null;
        for(int i = 1;i < preorder.length;i++){
            if(st.peek().val > preorder[i]){
                TreeNode x = new TreeNode(preorder[i]);
                root.left = x;
                root = root.left;
                st.push(root);
            }
            else{
                while(st.size()!=0 && preorder[i] > st.peek().val){
                    temp = st.pop();
                }
                TreeNode y = new TreeNode(preorder[i]);
                temp.right = y;
                root = y;   
                st.push(root);
            }
        }
        return origRoot;
    }
}