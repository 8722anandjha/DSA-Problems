/*
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106
*/
public class OddEvenLinkedList {
    // whithout extra node
     public ListNode oddEvenList1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd= head;
        ListNode even= head.next;
        ListNode evenHead= even;
        while(even != null && even.next != null){
            odd.next= even.next;
            odd= odd.next;
            even.next= odd.next;
            even= even.next;
        }
        odd.next= evenHead;
        return head;
    }

    // with Two extra node
    public ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd= new ListNode(-1);
        ListNode even= new ListNode(-1);
        ListNode t1= odd;
        ListNode t2= even;
        ListNode t= head;
        while(t != null){
            t1.next= t;
            t1= t1.next;
            t= t.next;
            t2.next=t;
            if(t != null) t= t.next;
            t2=t2.next;
        }
        t1.next= even.next;
        return odd.next;
    } 
}
