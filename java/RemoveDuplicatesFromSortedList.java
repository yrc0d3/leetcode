public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head = new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head, cur = head.next;
        prev.next = null;
        while (cur != null) {
            if (cur.val != prev.val) {
                prev.next = cur;
                prev = cur;
                cur = cur.next;
                prev.next = null;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
