package lint;

import junit.framework.TestCase;

public class Binary extends TestCase{
	public String binaryRepresentation(String n) {
        int first = 0;
        double second =0f;
        if (n.indexOf(".")==-1) {
            first = Integer.parseInt(n);
        }
        else {
            first = Integer.parseInt(n.substring(0, n.indexOf(".")));
            second = Double.parseDouble(n.substring(n.indexOf(".")));
        } 
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<32 && first>= (1<<i); i++) {
            if  (((1<<i) & first)>0){
                sb.insert(0, "1");
            }
            else {
                sb.insert(0, "0");
            }
        }
        
        
        if (second>0 && sb.length()<31){
            if (sb.length()==0){
                sb.append("0");
            }
            sb.append(".");
            int start = sb.length();
            double i = 0.5f;
            while(second>0 && sb.length()-start<=32){
                if (second - i >=0) {
                    sb.append("1");
                    second = second -i;
                }
                else {
                    sb.append("0");
                }
                i = i/2;
            }
        }
        if (sb.length()>50){
            return "ERROR";
        }
        else {
            return sb.toString();
        }
    }
	public void testSample() {
		assertEquals("1000011111101111011000111.1010010001010001", this.binaryRepresentation("17817287.6418609619140625"));
	}
}
