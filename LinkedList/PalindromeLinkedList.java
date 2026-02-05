/*
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
*/
// code
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head== null || head.next == null) return true;
        // find middle node
        ListNode slow= head;
        ListNode fast= head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast= fast.next.next;
        }
        
        if(fast != null){
            slow= slow.next;
        }

// reverse the second half
        ListNode prev= null;
        ListNode pres= slow;
        while(pres != null){
            ListNode next= pres.next;
            pres.next= prev;
            prev= pres;
            pres= next;
        }
        // compare the both halves
        ListNode left= head;
        ListNode right =prev;
        while(left != null && right != null){
            if(left.val != right.val) {
                return false;
            }
            right= right.next;
            left= left.next;
        }
        return true;
}
}
