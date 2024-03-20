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
       
        //NBA = Node Before A, NAB = Node After B, LNOL2 = Last Node of List2 !!!
        
        ListNode NBA = list1;
        for(int i = 0; i<a-1; i++){
            NBA = NBA.next;
        }
        ListNode NAB = NBA;
        for(int i = a; i<=b+1; i++){
            NAB = NAB.next;
        }
        NBA.next = list2; 
        
        ListNode LNOL2 = list2;
        while(LNOL2.next!=null){
            LNOL2 = LNOL2.next;
        }
        LNOL2.next = NAB;
        return list1;
    }
}