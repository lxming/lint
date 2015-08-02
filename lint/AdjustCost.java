package lint;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

public class AdjustCost extends TestCase{
	
	 public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
	        int[][]cost = new int[A.size()][100];
	        
	        for(int i=1; i<100; i++) {
	            cost[0][i] = Math.abs(i-A.get(0));
	        }
	        
	        for(int i=1; i<A.size(); i++) {
	            for(int adjustedTo=1; adjustedTo<100; adjustedTo++) {
	                int start = adjustedTo-target<=0?1: Math.abs(adjustedTo-target);
	                int end = (target+adjustedTo>99)?99:(target+adjustedTo);
	                int min = cost[i-1][start];
	                for(int k=start+1; k<=end; k++) {
	                    min = Math.min(min , cost[i-1][k]);
	                }
	                cost[i][adjustedTo] = Math.abs(adjustedTo-A.get(i)) + min;
	            }
	        }
	        print(cost);
	        int min = Integer.MAX_VALUE;
	        for(int i=1; i<100; i++) {
	            min = Math.min(min, cost[A.size()-1][i]);
	        }
	        
	        return min;
	    }
	    
	 public void testSample() {
		 ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(20,25,35,45,55,65,75,85,25,35,45,55,15,15,15,7,2,11,15,11,15));
		 assertEquals(90, this.MinAdjustmentCost(al, 10));
	 }
	 
	 public static  void print(int[][] cost) {
		 for(int i=0; i<cost.length; i++) {
			 StringBuilder sb = new StringBuilder();
			 for (int j=0; j<cost[0].length; j++) {
				 sb.append(cost[i][j]).append(",");
			 }
			 System.out.println(sb);
			 
		 }
	 }
}
