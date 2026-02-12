/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1!=null){
            st1.push(temp1.val);
            temp1 = temp1.next;
        }
        while(temp2!=null){
            st2.push(temp2.val);
            temp2 = temp2.next;
        }
        int carry = 0;
        Stack<Integer> res = new Stack<>();
        while(st1.size() > 0 || st2.size() > 0 || carry!=0){
            int sum = 0;
            if(st1.size() > 0 && st2.size() == 0){
                sum = st1.pop() + carry;
            }
            else if(st1.size() == 0 && st2.size() > 0){
                sum = st2.pop() + carry;
            }
            else if(st1.size() > 0 && st2.size() > 0){
                sum = st1.pop() + st2.pop() + carry;
            }
            else{
                sum = carry;
            }
            res.push(sum%10);
            carry = sum/10;
        }
        ListNode t = new ListNode(0);
        ListNode temp3 = t;
        while(res.size() > 0){
            ListNode x = new ListNode(res.pop());
            temp3.next = x;
            temp3 = temp3.next;
        }
        return t.next;
    }
}