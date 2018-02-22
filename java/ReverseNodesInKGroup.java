public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode tmp = new ReverseNodesInKGroup().reverseKGroup(head, 5);
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, last = head;
        int count = k;
        while (last != null) {
            while (--count != 0 && last != null) {
                last = last.next;
            }
            if (last == null) {
                break;
            }
            ListNode nextHead = last.next;
            last.next = null;
            ListNode tmpTail = prev.next;
            prev.next = reverse(prev.next);
            tmpTail.next = nextHead;
            last = nextHead;
            prev = tmpTail;
            count = k;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode tmp;
        while (head != null) {
            tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
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
