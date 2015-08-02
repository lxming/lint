package lint.number_of_islands_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;
import lint.common.Point;

public class DisjointSet extends TestCase {
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<Integer>();
        if (operators == null) {
            return result;
        }
        HashMap<String, String> map = new HashMap<String, String>();
        int count = 0;
        for (int i = 0; i < operators.length; i++) {
            mark(map, operators[i]);
            String parent = operators[i].x + " " + operators[i].y;
            count += 1;
            int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 },
                    { -1, 0 } };
            for (int[] dir : dirs) {
                int x = dir[0] + operators[i].x;
                int y = dir[1] + operators[i].y;
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    String p = find(map, new Point(x, y));
                    if (p != null && !p.equals(parent)) {
                        union(map, p, parent);
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    void union(HashMap<String, String> map, String oldNode, String newNode) {
        map.put(oldNode, newNode);
    }

    String find(HashMap<String, String> map, Point p) {
        String c = p.x + " " + p.y;
        String parent = map.get(c);
        while (parent != null && !parent.equals(c)) {
            c = parent;
            parent = map.get(c);
        }
        return parent;
    }

    void mark(HashMap<String, String> map, Point p) {
        map.put(p.x + " " + p.y, p.x + " " + p.y);

    }

    public void testSample() {
        Point[] points = new Point[] { new Point(0, 0), new Point(0, 1) };
        assertTrue(1 == this.numIslands2(2, 2, points).get(1));
    }
}
