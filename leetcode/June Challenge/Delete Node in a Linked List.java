/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) 
    {
        node.val=node.next.val;//copy the value of that next node into your node
        node.next=node.next.next;//delete the next node;
    }
}