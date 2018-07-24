public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head = new InsertionSortList().insertionSortList(head);
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head, forward = head.next;
        cur.next = null;
        while (forward != null) {
            ListNode tmp = forward.next;
            if (forward.val < cur.val) {
                forward.next = cur;
                cur = forward;
            } else {
                ListNode prev = cur;
                while (prev.next != null && forward.val > prev.next.val) {
                    prev = prev.next;
                }
                if (prev.next == null) {
                    prev.next = forward;
                    forward.next = null;
                } else {
                    forward.next = prev.next;
                    prev.next = forward;
                }
            }
            forward = tmp;
        }

        return cur;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
