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
    public ListNode sortList(ListNode head) {

if(head == null || head.next == null){
    return head;
}

        ListNode slow = head ;
        ListNode fast = head.next ;
// find mid
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

ListNode second = slow.next ;
slow.next = null ;

ListNode left = sortList(head);
ListNode right = sortList(second);

return merge(left, right);
    }

  public ListNode merge(ListNode p1, ListNode p2) {
ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (p1 != null && p2 != null){
            if(p1.val <= p2.val){
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2 ;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if(p1 != null){
            tail.next = p1;
        }
        if(p2 != null){
            tail.next = p2;
        }
        return dummy.next;
    
}
}