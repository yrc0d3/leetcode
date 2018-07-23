public class ReorderList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ReorderList().reorderList(head);
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode h1 = head, h2 = slow.next;
        slow.next = null;
        h2 = reverse(h2);

        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        while (h1 != null && h2 != null) {
            cur.next = h1;
            h1 = h1.next;
            cur = cur.next;
            cur.next = null;

            cur.next = h2;
            h2 = h2.next;
            cur = cur.next;
            cur.next = null;
        }
        cur.next = h1;
        head.next = fakeHead.next.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode forward = head.next;
        head.next = null;
        while (forward.next != null) {
            ListNode tmp = forward.next;
            forward.next = head;
            head = forward;
            forward = tmp;
        }

        forward.next = head;
        return forward;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
