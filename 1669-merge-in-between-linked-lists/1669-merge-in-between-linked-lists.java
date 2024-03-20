/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeBeforeA = list1;
        for(int i = 0; i<a-1; i++){
            nodeBeforeA = nodeBeforeA.next;
        }
        ListNode nodeAfterB = nodeBeforeA;
        for(int i = a; i<=b+1; i++){
            nodeAfterB = nodeAfterB.next;
        }
        nodeBeforeA.next = list2;
        
        ListNode lastNodeOfList2 = list2;
        while(lastNodeOfList2.next != null){
            lastNodeOfList2 = lastNodeOfList2.next;
        }
        lastNodeOfList2.next = nodeAfterB;
        return list1;
    }
}