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
    public ListNode reverseKGroup(ListNode head, int k) {
       int count = 0 ;
       ListNode x = head ;

       while(x != null && count < k){
        count++;
        x = x.next;
       }

       if(count <k){
        return head;
       }  
ListNode prev = null;
ListNode curr = head;
while(curr != x){
    ListNode next = curr.next ;
    curr.next = prev ;
    prev = curr;
    curr = next;
}
head.next = reverseKGroup(curr , k);
return prev;

    }
}