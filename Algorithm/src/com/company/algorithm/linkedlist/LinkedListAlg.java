package com.company.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//链表算法相关
public class LinkedListAlg {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 6};
//        n4.next = n2;
//        Node h = removeNthFromEnd(n1, 3);
//        Node h = mergeTwoLists(n1, n4);
//        boolean result = hasCycle1(n1);
//        System.out.println(result);
        Node h = buildList(arr);
        h = reverseList2(h);
        printLinkedList(h);
    }

    public static void printLinkedList(Node h) {
        while (h != null) {
            System.out.print(h.val + "->");
            h = h.next;
        }
        System.out.print("NULL");
    }
    public static Node buildList(int[] arr) {
        Node sentry = new Node(0);
        Node temp = sentry;
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i], null);
            sentry.next = node;
            sentry = node;
        }
        Node head = temp.next;
        temp.next = null;
        return head;
    }
    /**
     * 题目： 删除链表倒数第N个节点，返回链表头结点
     * 输入： 1->2->3->4->5,  n = 2.
     * 输出： 1->2->3->5 头结点
     * @param head
     * @param n
     * @return
     */
    public static Node removeNthFromEnd(Node head, int n) {
        int len = getLength(head);
        System.out.println(len);
        Node sentry = new Node(0, head);
        Node cur = sentry;
        for (int i = 0; i < (len - n); i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return sentry.next;
    }
    public static int getLength(Node h) {
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
    public static Node mergeTwoLists(Node h1, Node h2) {
        Node sentry = new Node();
        Node l1 = h1, l2 = h2;
        Node result = sentry;
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
    public static boolean hasCycle(Node h) {
        Set<Node> set = new HashSet<Node>();
        while (h != null) {
            if (!set.add(h)) {
                return true;
            }
            h = h.next;
        }
        return false;
    }
    public static boolean hasCycle1(Node h) {
        if (h == null || h.next == null) {
            return false;
        }
        Node slow = h;
        Node fast = h.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    //反转链表 1. 头插法
    public static Node reverseList(Node h) {
        Node newHead = null;
        while (h != null) {
            Node temp = h.next; //先保存下一节点，下一步使用
            h.next = newHead;
            newHead = h;

            h = temp;
        }

        return newHead;
    }
    //反转链表 2. 使用栈
    public static Node reverseList2(Node h) {
        Stack<Node> stack = new Stack<>();
        while (h != null) {
            stack.push(h);
            h = h.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        Node temp = stack.pop();
        Node newHead = temp;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            temp.next = node;
            temp = node;
        }
        temp.next = null;
        return newHead;
    }
    // 反转链表 3. 递归
    public static Node reverseListS1(Node h) {
        //终止条件
        if (h == null || h.next == null)
            return h;
        //保存当前节点的下一个结点
        Node next = h.next;
        //从当前节点的下一个结点开始递归调用
        Node reverse = reverseList(next);
        //reverse是反转之后的链表，因为函数reverseList
        // 表示的是对链表的反转，所以反转完之后next肯定
        // 是链表reverse的尾结点，然后我们再把当前节点
        //head挂到next节点的后面就完成了链表的反转。
        next.next = h;
        //这里head相当于变成了尾结点，尾结点都是为空的，
        //否则会构成环
        h.next = null;
        return reverse;
    }
    // 发展链表 4. 递归
    public static Node reverseListS2(Node h) {
        if (h == null || h.next == null)
            return h;
        Node reverse = reverseList(h.next);
        h.next.next = h;
        h.next = null;
        return reverse;
    }
    public static Node reverseListS3(Node head) {
        return reverseListInt(head, null);
    }

    private static Node reverseListInt1(Node head, Node newHead) {
        if (head == null)
            return newHead;
        Node next = head.next;
        head.next = newHead;
        return reverseListInt1(next, head);
    }

    public static Node reverseListS4(Node head) {
        return reverseListInt(head, null);
    }

    private static Node reverseListInt(Node head, Node newHead) {
        if (head == null)
            return newHead;
        Node next = head.next;
        head.next = newHead;
        Node node = reverseListInt(next, head);
        return node;
    }
}