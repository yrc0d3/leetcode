public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = new RotateList().rotateRight(head, 1);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int count = 1;
        ListNode prev = head;
        while (prev.next != null) {
            prev = prev.next;
            count++;
        }

        k %= count;
        if (k == 0) {
            return head;
        }
        k = count - k;

        ListNode tail = prev;
        prev = head;
        while (--k > 0) {
            prev = prev.next;
        }
        ListNode newHead = prev.next;
        prev.next = null;
        tail.next = head;
        return newHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
