package org.example;

public class GetIntersectionNode<T> {
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
}
