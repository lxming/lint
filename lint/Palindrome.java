package lint;

import junit.framework.TestCase;

public class Palindrome extends TestCase {
	/**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            while(!isAlphaNumeric(s.charAt(i)) && i<j) {
                i++;
            }         
            while(!isAlphaNumeric(s.charAt(j)) && i<j) {
                j--;
            }    
            if (i!=j && Character.toLowerCase(s.charAt(i))!= Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    boolean isAlphaNumeric(char c) {
        return (c>='0' && c<='9') || (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
    
    public void testSimple() {
    	assertTrue(isPalindrome("aa"));
    }
}
