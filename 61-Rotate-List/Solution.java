class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0 ) {
            return head;
        }
        ListNode cur = head;
        int n = 1;

        while(cur.next != null) {
            cur = cur.next;
            n++;
        }
        cur.next = head;
        ListNode newHead = head;
        ListNode newTail = head;

        for (int i = 0; i < (n - k%n - 1); i++) {
            newTail = newTail.next;
        }
        newHead = newTail.next;
        newTail.next = null;
        return newHead;

    }
}