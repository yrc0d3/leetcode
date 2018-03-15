public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = new ReverseLinkedList2().reverseBetween(head, 1, 5);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        n = n - m;
        while (--m > 0) {
            prev = prev.next;
        }
        if (prev.next.next == null) {
            return head;
        }
        ListNode tail = prev.next, cur = tail.next;
        while (n-- > 0) {
            ListNode nextNode = cur.next;
            tail.next = nextNode;
            cur.next = prev.next;
            prev.next = cur;
            cur = nextNode;
        }

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
