package lint;

import java.util.ArrayList;

import junit.framework.TestCase;

public class FindSmaller  extends TestCase{
	 public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        STreeNode root = build(A, 0, A.length-1);
	        for(int i=0; i<A.length; i++) {
	            result.add(findSmaller(root, A, i));
	        }
	        return result;
	    }
	    
	    int findSmaller(STreeNode root, int[] A, int idx) {
	        if (root!=null && root.end<idx && root.max<A[idx]){
	            return root.end-root.start+1;
	        }
	        else if (root!=null && root.start<idx){
	            return findSmaller(root.left, A, idx) + findSmaller(root.right, A, idx);
	        }
	        return 0;
	    }
	    
	    STreeNode build(int[]A, int start, int end) {
	        if (start>end) {
	            return null;
	        }
	        else if (start==end) {
	            return new STreeNode(A[start], start, end);
	        }
	        else {
	            int m = (start+end)/2;
	            STreeNode left = null, right= null;
	            int max = Integer.MIN_VALUE;
	            if (start<=m) {
	                left = build(A, start, m);
	                max = Math.max(max, left.max);
	            }
	            if (end>m) {
	                right = build(A, m+1, end);
	                max = Math.max(max, right.max);
	            }
	            STreeNode node = new STreeNode(max, start, end);
	            node.left = left;
	            node.right = right;
	            return node;
	            
	        }
	    }
	    
	    public void testSample() {
	    	int[] A = new int[]{1,2,7,8,5};
	    	ArrayList<Integer> a = this.countOfSmallerNumberII(A);
	    	assertTrue(1==a.get(1));
	    }
}


class STreeNode {
    int max;
    int start;
    int end;
    STreeNode left;
    STreeNode right;
    STreeNode(int max,  int start, int end) {
        this.max = max;
        this.start = start;
        this.end = end;
    }
}
