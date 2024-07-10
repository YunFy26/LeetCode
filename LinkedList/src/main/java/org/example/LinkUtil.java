package org.example;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * 链表工具
 * @param <T>
 */
public class LinkUtil<T> {
    /**
     * 寻找两个链表交点-无环
     * @param headA
     * @param headB
     * @return
     */
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

    /**
     * 反转链表-栈
     * @param head
     * @return
     */
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

    /**
     * 迭代法反转链表
     * @param head
     * @return
     */
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

    /**
     * 反转指定位置的链表
     * @param head
     * @param left
     * @param right
     * @return
     */
    private ListNode<T> reverseBetween(ListNode<T> head, int left, int right) {
        // TODO
        return null;
    }


    /**
     * 合并两个有序链表 - 以空间换时间
     * @param list1
     * @param list2
     * @return
     */
    private ListNode<Integer> mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2){
//        ListNode<T> cur = null;
        ListNode<Integer> ret = new ListNode<>(0);
        ListNode<Integer> dump = ret;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val) {
                ret.next = list1;
                ret = ret.next;
                list1 = list1.next;
            }else {
                ret.next = list2;
                ret = ret.next;
                list2 = list2.next;
            }
        }
        if (list1 == null) ret.next = list2;
        else ret.next = list1;

        return dump.next;
    }

    /**
     * 给定一个已排序的链表的头head，删除所有重复的元素，使每个元素只出现一次，返回已排序的链表
     * 递归
     * @param head head node
     * @return
     */
    private ListNode<Integer> deleteDuplicates_1(ListNode<Integer> head){

        if (head == null || head.next == null) return head;

        if (head.val == head.next.val){
            return deleteDuplicates_1(head.next);
        }else {
            head.next = deleteDuplicates_1(head.next);
            return head;
        }

    }

    /**
     * 指针
     * @param head
     * @return
     */
    private ListNode<Integer> deleteDuplicates_2(ListNode<Integer> head){

        ListNode<Integer> cur = head;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return cur;

    }

    /**
     * 删除链表的倒数第 n 个结点，并且返回链表的头结点：获取长度 -> 删除
     * @param head
     * @param n
     * @return
     */
    private ListNode<Integer> removeNthFromEnd(ListNode<Integer> head, int n) {
        ListNode<Integer> cur = new ListNode<>(0, head);
        ListNode<Integer> dump = cur;
        int length = getLength(head);
        for (int i = 0; i < length - n; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dump.next;
    }

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    private ListNode<Integer> removeNthFromEnd2(ListNode<Integer> head, int n) {

        ListNode<Integer> cur = new ListNode<>(0, head);
        ListNode<Integer> first = head;
        ListNode<Integer> second = cur;

        
        return ;
    }

    /**
     * 获取ListNode长度
     * @param list
     * @return
     */
    private int getLength(ListNode<Integer> list){
        int count = 0;
        while (list != null){
            count ++;
            list = list.next;
        }
        return count;
    }


}
