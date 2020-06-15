package digui;

import linkedList.Solution;

public class Sum {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }

        //通过传入数组来构建链表
        public ListNode(int[] arr) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("数组为null");
            }
            this.val = arr[0];
            ListNode node = this;
            for (int i = 1; i < arr.length; i++) {
                node.next = new ListNode(arr[i]);
                node = node.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode listNode = this;
            while (listNode != null) {
                res.append(listNode.val + "->");
                listNode = listNode.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

    /**
     * 递归求数组的和
     *
     * @param arr
     * @return
     */
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    //  计算arr[l...n)这个区间内所有数字的和
    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }

        return arr[l] + sum(arr, l + 1);
    }


    /**
     * 用递归的方法删除链表中的某一个元素
     */
    public static ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call remove " + val + "in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return null");
            return null;
        }
        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);
        ListNode ret = head;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
        }
        System.out.print(depthString);
        System.out.println("Return " + ret);

        return ret;
        //上面这段代码又可以改为三目表达式

    }

    private static String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");//深度越深字符串越长
        }
        return res.toString();
    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
     * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead.val == pHead.next.val) {
            ListNode node = pHead.next;
            while (node != null && node.val == pHead.val) {
                node = node.next;
            }
            return deleteDuplication(node);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        /*int[] arr = {1,2,3,4,5};
        System.out.println(sum(arr));*/
        /*int[] arr = {5,4,3,2,1,5};
        ListNode listNode = new ListNode(arr);
        System.out.println(Sum.removeElements(listNode, 5,0));*/
        int[] arr1 = {5, 1, 3, 3, 4, 4,5};
        ListNode listNode1 = new ListNode(arr1);
        System.out.println(deleteDuplication(listNode1));
    }
}
