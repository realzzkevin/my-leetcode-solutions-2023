class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode cur = new ListNode(0);
        ListNode head = cur;

        while(l1 != null || l2 != null || c > 0) {
            cur.next = new ListNode(0);
            cur = cur.next;
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            cur.val = (x+y+c) % 10;
            c = (x+y+c) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

        }

        return head.next;

    }
}