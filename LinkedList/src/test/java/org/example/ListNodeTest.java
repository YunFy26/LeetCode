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
}
