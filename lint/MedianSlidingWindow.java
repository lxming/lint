package lint;

import java.util.ArrayList;
import java.util.TreeSet;

import junit.framework.TestCase;

public class MedianSlidingWindow   extends TestCase{
	 public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
	        int n = nums.length;
	        TreeSet<MNode> small = new TreeSet<MNode>();
	        TreeSet<MNode> big = new TreeSet<MNode>();
	        int half = (k+1)/2;
	        for(int i=0; i<k-1; i++) {
	            add(small, big, half, new MNode(i, nums[i]));
	        }
	        ArrayList<Integer> result = new ArrayList<Integer> ();
	        for(int i=k-1; i<n; i++) {
	            add(small, big, half, new MNode(i, nums[i]));
	            result.add(small.last().val);
	            remove(small,big, half, new MNode(i-k+1, nums[i-k+1]));
	        }
	        return result;
	    }
	    
	    void add(TreeSet<MNode>small, TreeSet<MNode> big, int size, MNode node) {
	        if (small.size()<size) {
	            small.add(node);
	        }
	        else {
	            big.add(node);
	        }
	        if (small.size()==size) {
	            if (big.size()>0 && small.last().val>big.first().val) {
	                MNode s = small.last();
	                MNode b = big.first();
	                small.remove(s);
	                big.remove(b);
	                small.add(b);
	                big.add(s);
	            }
	        }
	    }
	    
	    void remove(TreeSet<MNode>small, TreeSet<MNode> big, int size, MNode node) {
	        if (small.contains(node)) {
	            small.remove(node);
	        }
	        else {
	            big.remove(node);
	        }
	    }
	    
	    public void testSample() {
	    	int[] sample = new int[]{1,2,7,7,2,10,3,4,5};
	    	 ArrayList<Integer> result = this.medianSlidingWindow(sample, 2);
	    	 assertEquals(new Integer(2), result.get(0));
	    }
}




class MNode implements Comparable<MNode>{
    int idx;
    int val;
    MNode(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
    public int compareTo(MNode other) {
        MNode o =(MNode)other;
        if (this.val == o.val) {
            return this.idx - o.idx;
        }
        return this.val - o.val;
    }
    public boolean equals(Object other) {
        MNode o =(MNode)other;
        return this.idx==o.idx;
    }
    
    public String toString() {
    	return idx + ":"+val;
    }
}

