package lint;

import junit.framework.TestCase;

public class LongestCommonPrefix  extends TestCase {
	/**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        int i=0;
        if (strs.length==0) {
            return "";
        }
        else if (strs.length==1) {
            return strs[0];
        }
        boolean done = false;
        while (i<strs[0].length() && !done) {
            Character c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if (strs[j].length()<=i || strs[j].charAt(i)!=c) {
                    done = true;
                    break;
                }
            }
            i++;
        }
        return strs[0].substring(0,i-1);
    }
    
    public void testSample() {
    	String[] sample = new String[]{"ABCD","ABEF","ACEF"};
    	assertEquals("A", this.longestCommonPrefix(sample));
    }
}
