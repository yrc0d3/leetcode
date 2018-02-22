import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1. Two-Way merge
 * 2. K-Way Merge using Heap (or using PriorityQueue instead)
 * 3. K-Way Merge using Loser Tree
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        ListNode[] lists = {l1, l2};
//        ListNode ret = new MergeKSortedLists().mergeKLists1(lists);
//        ListNode ret = new MergeKSortedLists().mergeKLists2(lists);
        ListNode ret = new MergeKSortedLists().mergeKLists3(lists);
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    /*
    Two-Way Merge
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return twoWayMerge(lists, 0, lists.length - 1);
    }

    public ListNode twoWayMerge(ListNode[] lists, int low, int hi) {
        if (low == hi) {
            return lists[low];
        }
        int mid = low + (hi - low) / 2;
        ListNode left = twoWayMerge(lists, low, mid);
        ListNode right = twoWayMerge(lists, mid + 1, hi);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode la, ListNode lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (la != null && lb != null) {
            if (la.val < lb.val) {
                prev.next = la;
                la = la.next;
            } else {
                prev.next = lb;
                lb = lb.next;
            }
            prev = prev.next;
        }
        if (la != null) {
            prev.next = la;
        }
        if (lb != null) {
            prev.next = lb;
        }
        return dummy.next;
    }


    /*
    K-Way Merge using PriorityQueue
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val)
                return -1;
            else if (o1.val == o2.val)
                return 0;
            else
                return 1;
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    /*
    K-Way Merge using Loser Tree
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                lists[i] = new ListNode(Integer.MAX_VALUE);
            }
        }
        LoserTree lt = new LoserTree(lists);
        ListNode ret = lt.sort();
        return ret;
    }

    private static class LoserTree {
        // 内部结点，存储的是败者在data中的index；位置0存的是winner的index
        private int[] tree;
        // 叶子结点
        private ListNode[] data;
        private int k;

        public LoserTree(ListNode[] data) {
            this.k = data.length;
            this.data = new ListNode[k + 1];
            // 这个辅助结点很关键，方便初始化
            this.data[k] = new ListNode(Integer.MIN_VALUE);
            for (int i = 0; i < k; i++) {
                this.data[i] = data[i];
            }
            tree = new int[k];
            // 内部结点初始化为冠军
            Arrays.fill(tree, k);
            // 从后向前遍历叶子结点，依次调整内部结点
            for (int i = k - 1; i >= 0; i--) {
                adjust(i);
            }
        }

        public ListNode sort() {
            ListNode dummy = new ListNode(0);
            ListNode prev = dummy;
            int count = 0;
            while (data[tree[0]].val != Integer.MAX_VALUE) {
                int winner = tree[0];
                prev.next = data[winner];
                prev = prev.next;
                if (prev.next != null) {
                    data[winner] = prev.next;
                } else {
                    data[winner] = new ListNode(Integer.MAX_VALUE);
                }
                adjust(tree[0]);
            }
            return dummy.next;
        }

        public void adjust(int winnerDataIndex) {
            int parentIndex = (winnerDataIndex + k) / 2;
            while (parentIndex > 0) {
                // 败者留在父结点
                if (data[tree[parentIndex]].val <= data[winnerDataIndex].val) {
                    int tmp = tree[parentIndex];
                    tree[parentIndex] = winnerDataIndex;
                    winnerDataIndex = tmp;
                }
                parentIndex = parentIndex / 2;
            }
            tree[0] = winnerDataIndex;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
