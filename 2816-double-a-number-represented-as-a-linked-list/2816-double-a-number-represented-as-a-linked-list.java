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
    public ListNode doubleIt(ListNode head) {
        // the logic we will use here is REVERSE -> DOUBLE -> REVERSE
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode newHead = prev;
        ListNode t = new ListNode(0);
        ListNode temp = t;
        int carry = 0;
        while(newHead!=null || carry!=0){
            int sum = 0;
            if(newHead!=null){
                sum = sum + (newHead.val * 2) + carry;
                newHead = newHead.next;
            }
            else{
                sum = sum + carry;
            }
            carry = sum / 10;
            ListNode x = new ListNode(sum%10);
            temp.next = x;
            temp = temp.next;
        }
        ListNode newHead2 = t.next;
        prev = null;
        curr = newHead2;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}