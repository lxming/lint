package lint;

import java.util.Stack;

import junit.framework.TestCase;

public class SimplifyPath extends TestCase {
	public String simplifyPath(String path) {
        Stack<String>stack = new Stack<String>();
        String[] fields = path.split("/");
        for(int i=0; i<fields.length; i++) {
            String field = fields[i];
            if (".".equals(field) || "".equals(field)) {
                continue;
            }
            else if ("..".equals(field) && stack.size()>0) {
                stack.pop();
            }
            else {
                stack.push(field);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size()>0) {
            sb.append(stack.pop()).append("/");
        }
        if (sb.length()>0) {
            return sb.reverse().toString();
        }
        else {
            return "/";
        }
	}
    
    public void testExample() {
    	assertEquals("/...", this.simplifyPath("/..."));
    }
}
