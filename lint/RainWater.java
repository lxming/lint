package lint;

import junit.framework.TestCase;

public class RainWater extends TestCase {
	/**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights.length<=2){
            return 0;
        }
        int l=0;
        int total = 0;
        while(true) {
            while( l<heights.length-1 && heights[l]<=heights[l+1]) {l++;};
            int r = l+1;
            while(r<heights.length-1 && heights[r]<heights[l]) {r++;}
            int height = Math.min(heights[l], heights[r]);
            for(int i=l+1; i<r; i++) {
                total = total + height - heights[i];
            }
            if (r==heights.length-1) {
                break;
            }
            l = r;
        }
        return total;
    }
    
    public void testSample() {
    	int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    	assertEquals(6, this.trapRainWater(a));
    }
}
