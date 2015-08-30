package lint.find_peak_element_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param A
     *            : An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A.length == 0) {
            return result;
        }
        int t = 1;
        int b = A.length - 1;
        int l = 1;
        int r = A[0].length - 1;
        while (l <= r && t <= b) {
            int column = (l + r) / 2;
            int row = (t + b) / 2;
            int j = row;
            int i = column;
            for (int k = l; k <= r; k++) {
                if (A[row][k] > A[j][i]) {
                    j = row;
                    i = k;
                }
            }
            for (int k = t; k <= b; k++) {
                if (A[k][column] > A[j][i]) {
                    j = k;
                    i = column;
                }
            }
            if (A[j][i] > A[j + 1][i] && A[j][i] > A[j - 1][i]
                    && A[j][i] > A[j][i + 1] && A[j][i] > A[j][i - 1]) {
                result.add(j);
                result.add(i);
            } else {
                if (i == column) {
                    if (j < row) {
                        b = row - 1;
                    } else if (j > row) {
                        t = row - 1;
                    }
                    if (A[j][i] < A[j][i - 1]) {
                        r = column - 1;
                    } else {
                        l = column + 1;
                    }
                } else {
                    if (i < column) {
                        r = column - 1;
                    } else if (i > column) {
                        l = column + 1;
                    }
                    if (A[j][i] < A[j - 1][i]) {
                        b = row - 1;
                    } else {
                        t = row + 1;
                    }
                }
            }

        }
        return result;
    }
}
