class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1 ) {
            return head;
        }
        ListNode point = head;
        ListNode ktail = null;
        ListNode newHead = null;

        while(point != null) {
            int count = 0;
            point = head;
            while(count < k && point!= null) {
                point = point.next;
                count++;
            }
            if(count == k) {
                //start of reverse sublink
                ListNode prev = null;
                ListNode cur = head;
                while(count > 0) {
                    ListNode temp = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = temp;
                    count--;
                }
                //end of reverse sublink prev node is the head now;
                if(newHead == null) {
                    newHead = prev;
                }

                if(ktail != null) {
                    ktail.next = prev;
                }

                ktail = head;
                head = point;

            }

            if(ktail != null) {
                ktail.next = head;
            }

        }
        return newHead;
    }
}