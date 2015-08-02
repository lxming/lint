package lint;

import junit.framework.TestCase;

public class Atoi  extends TestCase{
	  public int atoi(String str) {
	        StringBuilder sb= new StringBuilder();
	        for(int i=0; i<str.length(); i++ ) {
	            char c = str.charAt(i);
	            if (c=='-' ||c=='+' || c>='0' && c<='9') {
	                sb.append(str.charAt(i));
	            }
	            if (c=='.') {
	                break;
	            }
	        }
	        str = sb.toString();
	        try{
	            long l = Long.parseLong(str);
	            if (l>Integer.MAX_VALUE){
	                return Integer.MAX_VALUE;
	            }
	            else if (l<Integer.MIN_VALUE) {
	                return Integer.MIN_VALUE;
	            }
	            return (int)l;
	        }
	        catch(Exception ex ) {
	            return 0;
	        }
	    }
    
	public void testSample() {
		assertEquals(-5211314, atoi("    -5211314"));
		assertEquals(-1111, atoi("   +-1111 "));
	}
}
