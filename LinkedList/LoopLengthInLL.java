public class LoopLengthInLL {
    public int findLength(ListNode head){
        ListNode fast= head;
        ListNode slow= head;
        int length= 0;
        while (fast != null && fast.next != null) {
            fast= fast.next.next;
            slow= slow.next;
            if (fast == slow) {
                ListNode temp= slow;
                do{
                    temp= temp.next;
                    length++;
                }while(temp != slow);
                break;
            }
        }
        if(length ==0) return 0;
        return length;
    }
}
