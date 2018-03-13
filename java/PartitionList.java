public class PartitionList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode tmp = new PartitionList().partition(head, 3);
        while (tmp != null) {
            System.out.print(tmp.val + ",");
            tmp = tmp.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(0), l2 = new ListNode(0);
        ListNode p1 = l1, p2 = l2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = l2.next;
        p2.next = null;
        return l1.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
