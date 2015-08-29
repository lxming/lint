package lint.find_peak_element;

public class Solution {
    /**
     * @param A
     *            : An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A.length < 3) {
            return -1;
        }
        int l = 1;
        int r = A.length - 2;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] > A[m - 1] && A[m] > A[m + 1]) {
                return m;
            } else if (A[m] > A[m - 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
}
