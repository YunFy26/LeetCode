package org.example;

import org.junit.Test;

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
}
