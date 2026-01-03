/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        while(temp!=null){
            Node t = temp.next;
            if(temp.child!=null){//check if child pointer is not null
                Node a = flatten(temp.child);
                temp.next = a;//connecting in start
                a.prev = temp;
                while(a.next!=null){// take this pointer to end to connect other end
                    a = a.next;
                }
                a.next = t;//here we connect other end
                if(t!=null) t.prev = a;
            }
            temp.child = null;//as we have a doubly linked list so we make sure every child pointer is null at the end and only two next and prev pointers are not null
            temp = temp.next;
        }
        return head;
    }
}