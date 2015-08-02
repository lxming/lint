package lint.number_of_islands_ii;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import lint.common.Point;

/**
 * 
 * This solution is based on recursively coloring all neighboring nodes to the
 * node with smallest sequence number.
 *
 */
public class Color {
    /**
     * @param n
     *            an integer
     * @param m
     *            an integer
     * @param operators
     *            an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        int[][] map = new int[n][m];
        List<Integer> result = new ArrayList<Integer>();
        if (operators == null || operators.length == 0) {
            return result;
        }

        for (int i = 0; i < operators.length; i++) {
            map[operators[i].x][operators[i].y] = -1;
            TreeSet<Integer> neighbors = neighbors(map, operators[i].x,
                    operators[i].y);
            if (i == 0) {
                result.add(1);
            } else {
                result.add(result.get(i - 1) + 1 - neighbors.size());
            }
            if (neighbors.size() == 0) {
                color(map, operators[i].x, operators[i].y, i + 1);
            } else {
                color(map, operators[i].x, operators[i].y, neighbors.first());
            }

        }
        return result;
    }

    TreeSet<Integer> neighbors(int[][] map, int x, int y) {
        int[][] dirs = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < map.length && newY >= 0
                    && newY < map[0].length && map[newX][newY] != 0) {
                set.add(map[newX][newY]);
            }
        }
        return set;
    }

    void color(int[][] map, int x, int y, int seq) {
        if (x < 0 || y < 0 || x >= map.length || y >= map[0].length
                || map[x][y] == 0 || map[x][y] == seq) {
            return;
        }
        map[x][y] = seq;
        color(map, x - 1, y, seq);
        color(map, x + 1, y, seq);
        color(map, x, y - 1, seq);
        color(map, x, y + 1, seq);

    }

}
