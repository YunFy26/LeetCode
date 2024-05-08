package org.example;

import java.util.Stack;

public class LinkUtil<T> {
    // 两个链表交点
    private ListNode<T> getIntersectionNode(ListNode<T> headA, ListNode<T> headB) {
        if(headA == null || headB == null) return null;
        ListNode<T> pA = headA;
        ListNode<T> pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
    // 反转链表 - 栈
    private ListNode<T> reverseList1(ListNode<T> head) {
        Stack<ListNode<T>> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }

        if(stack.isEmpty()){
            return null;
        }
        ListNode<T> newLink = stack.pop();
        ListNode<T> temp = newLink;
        while(!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return newLink;
    }
    // 反转链表 - 迭代
    private ListNode<T> reverseList2(ListNode<T> head) {
        ListNode<T> prev = null;
        ListNode<T> curr = head;
        while(curr != null){
            ListNode<T> nextTemp = curr.next; // 保存当前节点的下一个节点，临时变量
            curr.next = prev;   // 将当前节点的next指针指向前一个节点<本来next是指向后一个节点>
            prev = curr;        // prev指针指向当前节点
            curr = nextTemp;    // curr指针指向下一个节点     重复以上过程，更改所有节点的next指针，使next指针都指向前一个节点
        }
        return prev;
    }
    // 反转链表 - 指定位置
    private ListNode<T> reverseBetween(ListNode<T> head, int left, int right) {
        // TODO
        return null;
    }

}
