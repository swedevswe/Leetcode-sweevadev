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
    public ListNode mergeNodes(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        ListNode currentResult = dummy;
        
        ListNode current = head.next;
        int sum = 0;
        
        while(current != null){
            if(current.val != 0){
                sum += current.val;
            }else{
                currentResult.next = new ListNode(sum);
                currentResult = currentResult.next;
                sum = 0;
            }
            current = current.next;
        }
        return dummy.next;
    }
}