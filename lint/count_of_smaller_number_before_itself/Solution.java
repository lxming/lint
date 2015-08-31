package lint.count_of_smaller_number_before_itself;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null || A.length == 0) {
            return result;
        }
        SegmentTreeNode node = buildSegmentTree(0, 10000);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                result.add(0);
            } else {
                result.add(query(node, 0, A[i] - 1));
            }
            update(node, A[i]);
        }
        return result;
    }

    public SegmentTreeNode buildSegmentTree(int start, int end) {
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start < end) {
            int mid = start + (end - start) / 2;
            node.left = buildSegmentTree(start, mid);
            node.right = buildSegmentTree(mid + 1, end);
            node.count = node.left.count + node.right.count;
        }
        return node;
    }

    public int query(SegmentTreeNode node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.count;
        }
        int leftCount = 0, rightCount = 0;
        int mid = node.start + (node.end - node.start) / 2;
        if (start <= mid) {
            if (end <= mid) {
                leftCount = query(node.left, start, end);
            } else {
                leftCount = query(node.left, start, mid);
            }
        }
        if (end > mid) {
            if (start > mid) {
                rightCount = query(node.right, start, end);
            } else {
                rightCount = query(node.right, mid + 1, end);
            }
        }
        return leftCount + rightCount;
    }

    public void update(SegmentTreeNode node, int index) {
        if (node.start == index && node.end == index) {
            node.count = node.count + 1;
        } else {
            int mid = node.start + (node.end - node.start) / 2;
            if (node.start <= index && index <= mid) {
                update(node.left, index);
            } else if (mid < index && index <= node.end) {
                update(node.right, index);
            }
            node.count = node.left.count + node.right.count; // or node.count =
                                                             // node.count+1;
        }
    }
}

class SegmentTreeNode {
    int start, end;
    int count;
    SegmentTreeNode left;
    SegmentTreeNode right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.count = 0;
    }
}
