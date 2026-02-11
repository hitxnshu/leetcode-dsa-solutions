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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            temp = temp.next;
        }
        temp = head;
        if(head == null || head.next == null){
            return head;
        }//important edge case to be mentioned
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        while(k > n){
            k = k - n;
        }//important
        temp = head;
        int m = n-k;
        for(int i = 0;i < m;i++){
            temp = temp.next;
        }
        ListNode t = new ListNode(0);
        ListNode temp2 = t;
        for(int i = 0;i < n;i++){
            ListNode x = new ListNode(temp.val);
            temp2.next = x;
            temp2 = temp2.next;
            temp = temp.next;
        }
        return t.next;
    }
}