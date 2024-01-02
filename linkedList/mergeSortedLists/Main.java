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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode headNode = new ListNode();
        headNode.val = 69; // Assuming you want to keep this logic

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val || list1 == null) {
                if (headNode.val == 69) {
                    headNode.val = list2.val;
                    headNode.next = null;
                    list2 = list2.next;
                    continue;
                }
                ListNode newNode = new ListNode(list2.val, null);
                list2 = list2.next;
                addNode(headNode, newNode);
            } else if (list1.val < list2.val || list2 == null) {
                if (headNode.val == 69) {
                    headNode.val = list1.val;
                    headNode.next = null;
                    list1 = list1.next;
                    continue;
                }
                ListNode newNode = new ListNode(list1.val, null);
                list1 = list1.next;
                addNode(headNode, newNode);
            }
        }

        // Append the remaining elements of list1 or list2
        if (list1 != null) {
            addNode(headNode, list1);
        } else if (list2 != null) {
            addNode(headNode, list2);
        }

        return headNode;
    }

    private static void addNode(ListNode head, ListNode newNode) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
}
