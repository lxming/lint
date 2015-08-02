package lint;

import java.util.Stack;

import junit.framework.TestCase;

public class Expression  extends TestCase{
	 /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        if (expression.length==0) {
            return 0;
        }
        Stack<String> stack=new Stack<String>();
        for(int i=0; i<expression.length; i++) {
            String e = expression[i];
            if ("+".equals(e) || "-".equals(e) || "*".equals(e) || "/".equals(e) || "(".equals(e)) {
                stack.push(e);
            }
            else if (")".equals(e)) {
                int result = calculateHead(stack);
                stack.pop();
                stack.push(Integer.toString(result));
            }
            else {
				String head = null;
				if (stack.size() > 0) {
					head = stack.peek();
				}
				stack.push(e);
				if ("*".equals(head) || "/".equals(head) || "+".equals(head)
						|| "-".equals(head)) {
					int result = calculateHead(stack);
					stack.push(Integer.toString(result));
				}

            }
        }
        return Integer.parseInt(stack.pop());
    }
    
    int calculateHead(Stack<String> stack) {
        Integer op2 = Integer.parseInt(stack.pop());
        String operator = stack.pop();
        Integer op1 = Integer.parseInt(stack.pop());
        int result = 0;
        switch (operator) {
            case "+": result = op1+op2; break;
            case "-": result = op1-op2; break;
            case "*": result = op1*op2; break;
            case "/": result = op1/op2; break;
            default: break;
        }
        return result;    
                
    }
    
    public void testSample() {
    	String[] expression = new String[]{"1","+","2"};
    	assertEquals(3, this.evaluateExpression(expression));
    	expression = new String[]{"(","1","+","2",")"};
    	assertEquals(3, this.evaluateExpression(expression));
    	
    }
}
