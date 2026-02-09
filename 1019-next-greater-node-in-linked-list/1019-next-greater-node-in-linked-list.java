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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        int[] arr = new int[size];
        temp = head;
        int i = 0;
        while(temp != null){
            arr[i] = temp.val;
            i++;
            temp = temp.next;
        }
        int[] res = new int[size];
        for(int k = 0;k < size;k++){
            res[k] = 0;
            for(int j = k+1;j < size;j++){
                if(arr[j] > arr[k]){
                    res[k] = arr[j];
                    break;
                }
            }
        }
        return res;
    }
}