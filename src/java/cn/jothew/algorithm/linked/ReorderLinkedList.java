package cn.jothew.algorithm.linked;

import java.util.regex.Pattern;

/**
 * 链表重排
 * 要求输出[S1,Sn,S2,Sn-1...]
 *
 * 思路：先将链表一分为2，将后半部分反转，然后交替组合
 */
class ReorderLinkedList {
    public void reorderList(Node head) {
        if (head == null) {
            return;
        }
        Node mid = middleNode(head);
        Node l1 = head;
        Node l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public void mergeList(Node l1, Node l2) {
        Node l1_tmp;
        Node l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}