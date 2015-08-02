package lint;

import java.util.Stack;

import junit.framework.TestCase;

public class Evaludate   extends TestCase{
	public int evaluateExpression(String[] expression) {
        if (expression.length==0) {
            return 0;
        }
        Stack<Integer> operands = new Stack<Integer>();
        Stack<String>operators = new Stack<String>();
        for(String e: expression) {
            if (!isOperator(e)) {
                operands.push(Integer.parseInt(e));
            }
            else {
                if ("(".equals(e)) {
                    operators.push(e);
                }
                else if (")".equals(e)) {
                    while(!"(".equals(operators.peek())) {
                        operands.push(cal(operators.pop(), operands.pop(), operands.pop()));
                    }
                    operators.pop();
                }
                else {
                    while(operators.size()>0 && canExecute(e, operators.peek())) {
                        operands.push(cal(operators.pop(), operands.pop(), operands.pop()));
                    }
                    operators.push(e);
                }
            }
        }
        while(operators.size()>0) {
            operands.push(cal(operators.pop(), operands.pop(), operands.pop()));
        }
        return operands.pop();
    }
    
    boolean canExecute(String op1, String op2) {
    	if ("(".equals(op2)){
    		return false;
    	}
        if (("*".equals(op1) || "/".equals(op1)) && ("+".equals(op2) || "-".equals(op2))){
            return false;
        }
        return true;
    }
    
    boolean isOperator(String s) {
        return s.equals("(") || s.equals(")") || s.equals("*")
            ||s.equals("+") ||s.equals("-") ||s.equals("/");
    }
    
    int cal(String operator, Integer op2, Integer op1) {
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
	    	String[] sample = new String[]{"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
	    	assertEquals(2, this.evaluateExpression(sample));
	    }
}
