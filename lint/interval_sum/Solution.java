package lint.interval_sum;

import java.util.ArrayList;

import lint.common.Interval;

public class Solution {
    /**
     * @param A
     *            , queries: Given an integer array and an query list
     * @return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, ArrayList<Interval> queries) {
        Node root = this.buildTree(A, 0, A.length - 1);
        ArrayList<Long> result = new ArrayList<Long>();
        for (Interval q : queries) {
            result.add(sum(root, q));
        }
        return result;
    }

    Long sum(Node root, Interval query) {
        if (root == null) {
            return 0L;
        }
        if (root.start >= query.start && root.end <= query.end) {
            return root.sum;
        } else {
            return sum(root.left, query) + sum(root.right, query);
        }
    }

    Node buildTree(int[] A, int start, int end) {
        Node n = new Node(start, end);
        if (start == end) {
            n.sum = A[start];
        } else {
            int m = (start + end) / 2;
            n.left = buildTree(A, start, m);
            n.right = buildTree(A, m + 1, end);
            n.sum = n.left.sum + n.right.sum;
        }
        return n;

    }

    class Node {
        int start;
        int end;
        long sum;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
