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
class BSTIterator {
    List<Integer> values;
    int index;
    public BSTIterator(TreeNode root) {
        values = new ArrayList<>();
        inorder(root);
        index = -1;
    }
    
    public int next() {
        return values.get(++index);
    }
    
    public boolean hasNext() {
        if((index+1) < values.size()){
            return true;
        }
        return false;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    } 
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */