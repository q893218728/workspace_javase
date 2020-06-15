package linkedList;

import java.util.ArrayList;
import java.util.List;


class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
    }

    //通过传入数组来构建链表
    public ListNode(int[] arr){
         if(arr==null||arr.length==0){
             throw new IllegalArgumentException("数组为null");
         }
         this.val = arr[0];
         ListNode node = this;
        for (int i = 1; i <arr.length ; i++) {
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

public class Solution {
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode x = dummyHead;

        while (list2 != null && list1 != null) {

            if (list1.val < list2.val) {
                ListNode node = new ListNode(list1.val);
                System.out.println(list1.val);
                dummyHead.next = node;
                dummyHead = dummyHead.next;
                list1 = list1.next;

            } else {
                ListNode node = new ListNode(list2.val);
                System.out.println(list2.val);
                dummyHead.next = node;
                dummyHead = dummyHead.next;
                list2 = list2.next;

            }

        }
        while (list1 != null) {
            ListNode node = new ListNode(list1.val);
            dummyHead.next = node;
            dummyHead = node;
            list1 = list1.next;
        }
        while (list2 != null) {
            ListNode node = new ListNode(list2.val);
            dummyHead.next = node;
            dummyHead = node;
            list2 = list2.next;
        }
        return x.next;

    }

    /**
     * 删除指定元素，有多少都删除
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {


        //如果头结点就是要删除的节点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        //如果head是null，返回null
        if (head == null) {
            return null;
        }


        //如果要删除的不是头结点
        ListNode prev = head;
        //条件是下一个是不是null来判断到没到最后
        while (prev.next != null) {

            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next; //考虑为什么要放在else里
            }
        }

        return head;
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点。
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode list1 = pHead1;
        ListNode list2 = pHead2;
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = 0;
        int length2 = 0;
        while (list1 != null) {
            list1 = list1.next;
            length1++;
        }
        list1 = pHead1;
        while (list2 != null) {
            list2 = list2.next;
            length2++;
        }
        list2 = pHead2;
        if (length1 > length2) {
            int tmp = length1 - length2;
            while (tmp > 0) {
                tmp--;
                list1 = list1.next;
            }
        }
        if (length2 > length1) {
            int tmp = length2 - length1;
            while (tmp > 0) {
                tmp--;
                list2 = list2.next;
            }
        }
        while (list1 != list2) {
            list1 = list1.next;
            list2 = list2.next;
            //若是为null，证明到了最后都没有相同的点
            if (list1 == null) {
                return null;
            }
            System.out.println(list1.val);
        }
        return list1;

    }

    /**
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
     * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
         return null;
    }

    public static void main(String[] args) {
       int[] arr = {2,5,46,12,18,46};
       ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        System.out.println(new Solution().removeElements(listNode, 46));
    }
}
