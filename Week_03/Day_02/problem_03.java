//plaindrome of  linked list

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
    public boolean isPalindrome(ListNode head) { //O(n)
        if(head == null || head.next == null) {
            return true;
        }

        ListNode midNode = findMid(head);

        //reverse the second half from mid
        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev; //head of right half
        ListNode left = head;

        //check left and right half
        while(right != null) {
            if(left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public ListNode findMid(ListNode head) {
        //Slow Fast Tachnique
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; 
            fast = fast.next.next; 
        }
        return slow;
    }
}
