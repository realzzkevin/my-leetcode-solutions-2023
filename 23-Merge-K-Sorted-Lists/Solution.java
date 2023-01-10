class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if((lists.length == 0 )) {
            return null;
        }

        List<Integer> aList = new ArrayList<>();
        for(ListNode n: lists) {
            while (n != null) {
                aList.add(n.val);
                n = n.next;
            }
        }
        Collections.sort(aList);
        ListNode head = new ListNode(0);
        ListNode cur = head;

        for(Integer n : aList){
            cur.next = new ListNode(n);
            cur = cur.next;
        }

        return head.next;
    }
}