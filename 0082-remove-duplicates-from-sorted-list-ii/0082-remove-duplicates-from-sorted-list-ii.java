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
    public ListNode deleteDuplicates(ListNode head) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        // we were facing a problem that in hashmap the input order was nto being preserved in output so we used linkedhashmap, here the order is preserved as inputted
        ListNode temp = head;
        while(temp!=null){
            if(map.containsKey(temp.val)){
                map.put(temp.val,map.get(temp.val) + 1);
            }
            else{
                map.put(temp.val,1);
            }
            temp = temp.next;
        }
        ListNode t = new ListNode(0);
        ListNode temp1 = t;
        for(int x : map.keySet()){
            if(map.get(x) == 1){
                ListNode y = new ListNode(x);
                temp1.next = y;
                temp1 = temp1.next;
            }
        }
        return t.next;
    }
}