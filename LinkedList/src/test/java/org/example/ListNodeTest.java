package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class ListNodeTest {
    private ListNode<Integer> deleteDuplicates_1(ListNode<Integer> head){

        if (head == null || head.next == null) return head;

        if (head.val == head.next.val){
            return deleteDuplicates_1(head.next);
        }else {
            head.next = deleteDuplicates_1(head.next);
            return head;
        }

    }

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

    @Test
    public void testDeleteDuplicates() {
        // Test case 1: 1 -> 1 -> 2 -> 3 -> 3 should return 1 -> 2 -> 3
        ListNode<Integer> list1 = new ListNode<>(1, new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(3)))));
//        ListNode<Integer> result1 = deleteDuplicates_1(list1);
//        assertEquals("1 -> 2 -> 3", result1.toString());
        ListNode<Integer> result2 = deleteDuplicates_2(list1);
        assertEquals("1 -> 2 -> 3", result2.toString());

    }

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

    private int getLength(ListNode<Integer> list){
        int count = 0;
        while (list != null){
            count ++;
            list = list.next;
        }
        return count;
    }

    @Test
    public void testRemoveNthFromEnd(){
        // 1 -> 1 -> 2 -> 3 -> 3
        ListNode<Integer> list1 = new ListNode<>(1, new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(3)))));
        // 1 -> 2
        ListNode<Integer> list2 = new ListNode<>(1, new ListNode<>(2));
        ListNode<Integer> result = removeNthFromEnd(list2, 2);
        assertEquals("2", result.toString());

    }

    public ListNode<Integer> swapPairs1(ListNode<Integer> head) {

        if (head == null || head.next == null) return head;

        ListNode<Integer> temp = head.next;
        head.next = swapPairs1(temp.next);
        temp.next = head;
        return temp;
    }

    public ListNode<Integer> swapPairs2(ListNode<Integer> head) {

        ListNode<Integer> dumpHead = new ListNode<>(0, head);
        ListNode<Integer> temp = dumpHead;
        while (temp.next != null && temp.next.next != null){
            ListNode<Integer> node1 = temp.next; //   1 2 3 4 5
            ListNode<Integer> node2 = temp.next.next; // 2 3 4 5
            temp.next = node2; // 2 3 4 5
            node1.next = node2.next; // 1 3 4 5
            node2.next = node1; // 2 1 3 4 5
            temp = node1;
        }
        return dumpHead.next;

    }

    @Test
    public void testSwapPairs(){
        ListNode<Integer> list1 = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))));
        ListNode<Integer> result = swapPairs2(list1);
        assertEquals("2 -> 1 -> 4 -> 3 -> 5", result.toString());
    }

    private ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        Stack<ListNode<Integer>> stack1 = new Stack<>();
        Stack<ListNode<Integer>> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode<Integer> dump = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0){
            int sum = carry;
            sum += stack1.isEmpty()? 0 : stack1.pop().val;
            sum += stack2.isEmpty()? 0 : stack2.pop().val;
            ListNode<Integer> head = new ListNode<>(sum % 10);
            head.next = dump;
            dump = head;
            carry = sum / 10;
        }
        return dump;
    }

    @Test
    public void testAddTwoNumbers(){
        ListNode<Integer> list1 = new ListNode<>(3, new ListNode<>(9, new ListNode<>(9, new ListNode<>(9, new ListNode<>(9, new ListNode<>(9, new ListNode<>(9, new ListNode<>(9, new ListNode<>(9, new ListNode<>(9))))))))));
//        ListNode<Integer> list2 = new ListNode<>(1, new ListNode<>(2, new ListNode<>(3, new ListNode<>(4, new ListNode<>(5)))));
        ListNode<Integer> list2 = new ListNode<>(7);
        ListNode<Integer> result = addTwoNumbers(list1, list2);
        System.out.println(result);
    }
}
