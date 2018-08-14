public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.random = head.next;
        head.next.random = head;
        RandomListNode cur = head;
        System.out.println("raw list:");
        while (cur != null) {
            System.out.printf("label:%d, next:%d, random:%d\n", cur.label, cur.next == null ? 0 : cur.next.label, cur.random == null ? 0 : cur.random.label);
            cur = cur.next;
        }

        RandomListNode copyHead = new CopyListWithRandomPointer().copyRandomList(head);
        cur = copyHead;
        System.out.println("copied list:");
        while (cur != null) {
            System.out.printf("label:%d, next:%d, random:%d\n", cur.label, cur.next == null ? 0 : cur.next.label, cur.random == null ? 0 : cur.random.label);
            cur = cur.next;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        RandomListNode copyHead = cur.next;
        while (cur != null) {
            RandomListNode tmp = cur.next.next;
            if (tmp != null) {
                cur.next.next = tmp.next;
            }
            cur.next = tmp;
            cur = tmp;
        }

        return copyHead;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
