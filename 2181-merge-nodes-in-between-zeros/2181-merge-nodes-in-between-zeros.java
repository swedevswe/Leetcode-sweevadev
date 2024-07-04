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
        //dummy node for head of the result list
        //current pointer to traverse the list
        //new current pointer to build the new list
        //sum variable for total values between 0's
        
        ListNode dummy = new ListNode(0);
        ListNode resultCurrent = dummy;
        
        ListNode current = head.next;
        int sum = 0;
        
        while(current!=null){
            if(current.val!=0){
                sum+=current.val;
            }else{
                resultCurrent.next = new ListNode(sum);
                resultCurrent = resultCurrent.next;
                sum = 0;
            }
            current = current.next;
        }
        return dummy.next;
    }
}