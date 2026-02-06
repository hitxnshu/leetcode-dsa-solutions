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
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        ListNode t = new ListNode(0);
        ListNode temp3 = t;
        while(temp1!=null || temp2!=null || carry!=0){
            int temp = 0;
            if(temp1 == null && temp2!=null){
                temp = temp2.val + carry;
                temp2 = temp2.next;
            }
            else if(temp1!=null && temp2 == null){
                temp = temp1.val + carry;
                temp1 = temp1.next;
            }
            else if(temp1!=null && temp2!=null){
                temp = temp1.val + temp2.val + carry; 
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else{
                temp = carry;
            }
            carry = temp / 10;
            ListNode x = new ListNode(temp%10);
            temp3.next = x;
            temp3 = temp3.next;        
        }
        return t.next;
    }
}