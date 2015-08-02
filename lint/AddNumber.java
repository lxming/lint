package lint;

public class AddNumber {
	 /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode fakeHead = new ListNode(0);
        ListNode curr=fakeHead;
        while(l1!=null || l2!=null) {
            int sum=carry;
            if (l1!=null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2!=null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            carry = sum/10;
        }
        return fakeHead.next;
    }
}
