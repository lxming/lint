package lint.segment_tree_query_ii;

public class Solution {
    /**
     * @param root
     *            , start, end: The root of segment tree and an segment /
     *            interval
     * @return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (partOf(root, start, end)) {
            return root.count;
        }
        if (overlap(root, start, end)) {
            return query(root.left, start, end) + query(root.right, start, end);
        } else {
            return 0;
        }
    }

    boolean overlap(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return false;
        }
        return root.end >= start && end >= root.start;
    }

    boolean partOf(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return true;
        } else {
            return root.end <= end && root.start >= start;
        }
    }
}