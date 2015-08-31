package lint.interval_sum_ii;

public class Solution {

    /* you may need to use some attributes here */
    Node root;

    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
          root= this.buildTree(A, 0, A.length-1);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return this.sum(root,start,end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modify(root, index, value);
    }
    
    Long modify(Node node, int index, int value) {
        if (node==null) {
            return 0L;
        }
        else if (node.start==index && node.end==index) {
            node.sum = value;
        }
        else if(node.start<=index && node.end>=index) {
            node.sum = modify(node.left, index, value) + modify(node.right, index, value);
        }
        return node.sum;
    }
    
    Long sum(Node root, int start, int end) {
            if (root==null) {
                return 0L;
            }
            if (root.start>=start && root.end<=end) {
                return root.sum;
            }
            else {
                return sum(root.left, start,end)+ sum(root.right, start,end);
            }
        }
        
    Node buildTree(int[] A, int start, int end) {
        if (A.length==0) {
            return null;
        }
        Node n = new Node(start,end);
        if (start==end) {
            n.sum=A[start];
        }
        else {
            int m=(start+end)/2;
             n.left = buildTree(A, start, m);
             n.right = buildTree(A, m+1, end);
            n.sum=n.left.sum + n.right.sum;
        }
        return n;
            
        }
        
        class Node{
            int start;
            int end;
            long sum;
            Node left;
            Node right;
            public Node(int start, int end) {
                this.start=start;
                this.end= end;
            }
        }
}

