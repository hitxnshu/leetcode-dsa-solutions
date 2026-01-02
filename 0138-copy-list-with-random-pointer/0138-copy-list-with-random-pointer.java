/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head1) {
        // deep copy
        Node head2 = new Node(0);
        Node bekar = head2;
        Node temp1 = head1;
        while(temp1!=null){
            Node x = new Node(temp1.val);
            bekar.next = x;
            bekar = bekar.next;
            temp1 = temp1.next;
        }
        head2 = head2.next;
        temp1 = head1;
        Node temp2 = head2;

        // merging both lists
        Node head3 = new Node(0);
        Node bekar2 = head3;
        while(temp1!=null){
            bekar2.next = temp1;
            bekar2 = bekar2.next;
            temp1 = temp1.next;

            bekar2.next = temp2;
            bekar2 = bekar2.next;
            temp2 = temp2.next;
        }
        head3 = head3.next;
        temp1 = head1;
        temp2 = head2;

        //assigning random pointers
        while(temp1!=null){
            if(temp1.random == null){
                temp2.random = null;
            }
            else{
                temp2.random = temp1.random.next;
            }
            temp1 = temp2.next;
            if(temp1!=null) temp2 = temp1.next;
        }
        temp1 = head1;
        temp2 = head2;

        // seperating the lists
        while(temp1 != null){
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if(temp1 == null) break;
            temp2.next = temp1.next;
            if(temp1.next == null) break;
            temp2 = temp2.next;
        }
        return head2;
    }
}