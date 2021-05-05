package com.company.algorithm.ArrayAlgorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//链表算法相关
public class LinkedListAlg {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n2;
//        ListNode h = removeNthFromEnd(n1, 3);
//        ListNode h = mergeTwoLists(n1, n4);
        boolean result = hasCycle1(n1);
        System.out.println(result);
//        printLinkedList(h);
    }

    public static void printLinkedList(ListNode h) {
        while (h != null) {
            System.out.print(h.val + "->");
            h = h.next;
        }
        System.out.print("NULL");
    }

    /**
     * 题目： 删除链表倒数第N个节点，返回链表头结点
     * 输入： 1->2->3->4->5,  n = 2.
     * 输出： 1->2->3->5 头结点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        System.out.println(len);
        ListNode sentry = new ListNode(0, head);
        ListNode cur = sentry;
        for (int i = 0; i < (len - n); i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return sentry.next;
    }
    public static int getLength(ListNode h) {
        int lentgh = 0;
        while (h != null) {
            lentgh++;
            h = h.next;
        }
        return lentgh;
    }

    /**
     * 题目： 合并两个有序链表
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * @param h1
     * @param h2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode sentry = new ListNode();
        ListNode l1 = h1, l2 = h2;
        ListNode result = sentry;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                sentry.next = l1;
                l1 = l1.next;
            } else {
                sentry.next = l2;
                l2 = l2.next;
            }
            sentry = sentry.next;
        }
        if (l1 != null) {
            sentry.next = l1;
        }
        if (l2 != null) {
            sentry.next = l2;
        }

        return result.next;
    }

    /**
     * 题目： 给定一个链表,判断链表中是否有环
     * 说明： 使用整数 pos 来表示链表尾连接到链表中的位置, pos 是 -1,则在该链表中没有环
     * @param h
     * @return
     */
    public static boolean hasCycle(ListNode h) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (h != null) {
            if (!set.add(h)) {
                return true;
            }
            h = h.next;
        }
        return false;
    }
    public static boolean hasCycle1(ListNode h) {
        if (h == null || h.next == null) {
            return false;
        }
        ListNode slow = h;
        ListNode fast = h.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode() {}

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}