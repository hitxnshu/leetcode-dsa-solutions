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
    public void helper(TreeNode root,String s,List<String> list){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            char ch = (char) (root.val + '0');
            s += ch;
            list.add(s);
            s = s.substring(0,s.length()-1);
            return;
        }
        char ch = (char) (root.val + '0');
        s += ch;
        helper(root.left,s,list);
        helper(root.right,s,list);
        if(s.length() > 0){
        s = s.substring(0,s.length()-1);
        }
    }
    public int sumNumbers(TreeNode root) {
        String s = "";
        List<String> list = new ArrayList<>();
        helper(root,s,list);
        int sum = 0;
        for(int i = 0;i < list.size();i++){
            int number = stringToNum(list.get(i));
            sum += number;
        }
        return sum;
    }
    public int stringToNum(String s){
        int num = 0;
        int pow = 1;
        for(int i = s.length()-1;i >= 0;i--){
            char ch = s.charAt(i);
            int x = ch - '0';
            num = num + (x * pow);
            pow *= 10;
        }
        return num;
    }
}