package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class AdjustCost2 extends TestCase{
	
	 public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
	        int max = Integer.MIN_VALUE;
	        for (int i = 0; i < A.size(); i++) {
	            int val = A.get(i);
	            max = Math.max(max, val);
	        }
	        
	        int range = max+1;
	        int[][] cost = new int[A.size()][range];
	        int curMin = 0;
	        for (int i = 0; i < range; i++) {
	            cost[0][i] = Math.abs(A.get(0)-i);
	        }
	        
	        for (int i = 1; i < A.size(); i++) {
	            curMin = Integer.MAX_VALUE;
	            for (int j = 0; j < range; j++) {
	                cost[i][j] = Integer.MAX_VALUE;
	                for (int diff = -1 * target; diff <= target; diff++) {
	                    int lastCol = j+diff;
	                    if (lastCol < 0) {
	                        continue;
	                    }
	                    if (lastCol >= range) {
	                        break;
	                    }
	                    int curAdj = Math.abs(A.get(i) - j);
	                    int totalAdj = cost[i-1][lastCol] + curAdj;
	                    cost[i][j] = Math.min(totalAdj, cost[i][j]);
	                    curMin = Math.min(curMin, totalAdj);
	                }
	            }
	        }
	        AdjustCost.print(cost);
	        return curMin;
	    }

	
	 public void testSample() {
		 ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(20,25,35,45,55,65,75,85,25,35,45,55,15,15,15,7,2,11,15,11,15));
		 assertEquals(90, this.MinAdjustmentCost(al, 10));
	 }

}
