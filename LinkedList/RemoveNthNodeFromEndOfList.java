/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 
*/
public class RemoveNthNodeFromEndOfList {

    // With Two pass, first find the length (N) of the List 
    // then put the temp node to the head and move temp (N-n) times
    // temp.next= temp.next.next;

     public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head== null || head.next== null){
            return null;
        }
      ListNode temp= head;
      int len= 0;
      while(temp != null ){
        temp = temp.next;
        len++;
      }
      if( len == n){
        return head.next;
      }
      temp = head;
      for(int i=1; i< len-n; i++){
        temp= temp.next;
      }
      temp.next= temp.next.next;
      return head;
    }

    // Singal pass, slow and fast pointer approach
    // create a dummy node and point slow and fast pointer to that dummy node
    // dummy.next= head;
    // move fast pointer n times first then move both pointer one by one till (fast !=null && fast.next != null)
    // slow.next= slow.next.next
    // return dummy.next

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n >0){
            fast= fast.next;
            n--;
        }
        while(fast != null && fast.next != null ){
            slow= slow.next;
            fast= fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;

    }
}
