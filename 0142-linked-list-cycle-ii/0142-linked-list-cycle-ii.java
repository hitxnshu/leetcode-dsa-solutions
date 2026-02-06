/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean isCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode temp = head;
        if(isCycle(head)){
            while(temp!=null && temp.next!=null){
                if(hs.contains(temp)){
                    return temp;
                }
                else{
                    hs.add(temp);
                }
                temp = temp.next;
            }
        }
        return null;
    }
}