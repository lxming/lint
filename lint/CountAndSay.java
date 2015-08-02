package lint;

import junit.framework.TestCase;

public class CountAndSay extends TestCase {
	 /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        String output="1";
        for (int i=1; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<output.length();) {
                if (output.charAt(j)=='1') {
                    if (j+1<output.length() && output.charAt(j+1)=='1') {
                        sb.append("21");
                        j+=2;
                    }
                    else {
                        sb.append("11");
                        j++;
                    }
                }
                else {
                    sb.append("12");
                    j++;
                }
            }
            output=sb.toString();
        }
        return output;
    }
    
    
    public void testCountAndSay() {
    	assertEquals("111221", this.countAndSay(5));
    }
}
