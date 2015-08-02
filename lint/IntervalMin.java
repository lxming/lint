package lint;

import java.util.ArrayList;

public class IntervalMin {
	    /**
	     *@param A, queries: Given an integer array and an query list
	     *@return: The result list
	     */
	    public ArrayList<Integer> intervalMinNumber(int[] A, 
	                                                ArrayList<Interval> queries) {
	        Node root = buildTree(A, 0, A.length-1);
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        for (Interval i: queries) {
	            result.add(min(root, i));
	        }
	        return result;
	    }
	    
	    int min(Node root, Interval query) {
	        if (root==null) {
	            return Integer.MAX_VALUE;
	        }
	        if (root.start>=query.start && root.end<=query.end) {
	            return root.min;
	        }
	        else {
	            return Math.min(min(root.left, query), min(root.right, query));
	        }
	    }
	    
	    
	    
	    
	    Node buildTree(int[] A, int start, int end) {
	        Node n = new Node(start,end);
	        if (start==end) {
	            n.min=A[start];
	        }
	        else {
	            int m=(start+end)/2;
	            n.left = buildTree(A, start, m);
	            n.right = buildTree(A, m+1, end);
	            n.min=Math.min(n.left.min, n.right.min);
	        }
	        return n;
	        
	    }
	    
	    class Node{
	        int start;
	        int end;
	        int min;
	        Node left;
	        Node right;
	        public Node(int start, int end) {
	            this.start=start;
	            this.end= end;
	        }
	    }

}
