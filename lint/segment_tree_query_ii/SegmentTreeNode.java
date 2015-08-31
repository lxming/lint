package lint.segment_tree_query_ii;

public class SegmentTreeNode {
    public int start, end, count;
    public SegmentTreeNode left, right;

    public SegmentTreeNode(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
        this.left = this.right = null;
    }
}
