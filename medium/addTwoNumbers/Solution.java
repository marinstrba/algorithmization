class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solution = new ListNode(0);
        ListNode current = solution;
        boolean hold = false;
        int result = 0;
        while (l1 != null || l2 != null || hold)
        {
            int x = (l1 == null) ? 0 : l1. val;
            int y = (l2 == null) ? 0 : l2. val;
            result = x + y;
            if (hold)
            {
                result += 1;
                hold = result >= 10 ? true : false;
            }
            if (result >= 10)
                hold = true;
            ListNode newNode = new ListNode(result % 10);
            current.next = newNode;
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

    return solution.next;
    }
}