package lint;

import java.util.Stack;

import junit.framework.TestCase;

public class LargestArea    extends TestCase{
	/**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i=0; i<=height.length;) {
            int h = (i==height.length)?0:height[i];
            if (stack.isEmpty()|| height[stack.peek()]<=h) {
                stack.push(i++);
            }
            else {
                int end = stack.pop();
                int start = (stack.isEmpty())?-1:stack.peek();
                int area = height[end] * (i-start-1);
                max = Math.max(area, max);
            }
        }
        return max;
    }
    
    public void testSample() {
    	int[]height = new int[]{2,0,2,1};
    	assertEquals(2, this.largestRectangleArea(height));
    }
}
