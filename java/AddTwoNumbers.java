public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode ret = new AddTwoNumbers().addTwoNumbers(l1, l2);
        while (ret != null) {
            System.out.print(ret.val + ",");
            ret = ret.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        int sum = 0, extra = 0;
        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += extra;
            extra = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
        }
        if (extra > 0) {
            prev.next = new ListNode(1);
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

