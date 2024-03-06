
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        // Example 1: Create a list with a cycle
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creates a cycle here
        
        Solution solution = new Solution();
        System.out.println("Example 1 has cycle: " + solution.hasCycle(head)); // Expected: true
        
        // Example 2: Create a list without a cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        
        System.out.println("Example 2 has cycle: " + solution.hasCycle(head2)); // Expected: false
    }
}
