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
        
        ListNode currResult = dummy;
        
        int sum = 0;
        
        ListNode current = head.next;
        
        while(current != null){
            if(current.val != 0){
                sum += current.val;
            }else{
                currResult.next = new ListNode(sum);
                currResult = currResult.next;
                sum = 0;
            }
            current = current.next;
        }
        return dummy.next;
    }
}