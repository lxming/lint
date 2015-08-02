package lint;

import junit.framework.TestCase;

public class ReorderList extends TestCase{
	/**
     * @param head: The head of linked list.
     * @return: void
     */
	public void reorderList(ListNode head) {  
        if (head==null || head.next==null || head.next.next==null) {
            return;
        }
        int steps = 0;
        ListNode curr = head;
        while(curr.next!=null) {
            steps++;
            curr = curr.next;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowprev = head;
        for(int i=0; i<steps/2; i++) {
            fast = fast.next;
        }
        while(fast.next!=null) {
            slowprev = slow;
            slow =slow.next;
            fast = fast.next;
        }
        slowprev.next=null;
        ListNode head2 = reverse(slow);
        slow.next = null;
        ListNode p1 = head;
        ListNode p2 = head2;
        while(p1!=null && p2!=null) {
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;
            p1.next = p2;
            if (t1!=null) {
            	p2.next = t1;
            }
            p1=t1;
            p2=t2;
        }
        
    }
    
    ListNode reverse(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
    
    public void testSample() {
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	ListNode l3 = new ListNode(3);
    	ListNode l4 = new ListNode(4);
    	l1.next = l2;
    	l2.next = l3;
    	this.reorderList(l1);
    }
}

