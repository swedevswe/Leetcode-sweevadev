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
        ListNode nBa = list1;
        for(int i = 0; i<a-1; i++){
            nBa = nBa.next;
        }
        ListNode nAb = nBa;
        for(int i = a; i<=b+1; i++){
            nAb = nAb.next;
        }
        nBa.next = list2; 
        
        ListNode lNl2 = list2;
        while(lNl2.next!=null){
            lNl2 = lNl2.next;
        }
        lNl2.next = nAb;
        return list1;
    }
}