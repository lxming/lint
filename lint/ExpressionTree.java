package lint;

import java.util.Stack;

import junit.framework.TestCase;

public class ExpressionTree  extends TestCase {
	public ExpressionTreeNode build(String[] expression) {
        Stack<ExpressionTreeNode> nodes = new Stack<ExpressionTreeNode> ();
        Stack<String>operators = new Stack<String>();
        for (String e: expression) {
            if (isOperator(e)) {
                if ("(".equals(e)) {
                    operators.push("(");
                }
                else if (")".equals(e)) {
                    while(!"(".equals(operators.peek())){
                        nodes.push(buildOpNode(operators.pop(), nodes.pop(), nodes.pop()));
                    }
                    operators.pop();
                }
                else {
                    while(operators.size()>0 && canExecute(e, operators.peek())){
                        nodes.push(buildOpNode(operators.pop(), nodes.pop(), nodes.pop()));
                    }  
                    operators.push(e);
                }
            }
            else {
                nodes.add(new ExpressionTreeNode(e));
            }
        }
        while(operators.size()>0) {
            nodes.push(buildOpNode(operators.pop(), nodes.pop(), nodes.pop()));
        }
        return nodes.pop();
    }
    
    ExpressionTreeNode buildOpNode(String op, ExpressionTreeNode right, ExpressionTreeNode left){
            ExpressionTreeNode node = new ExpressionTreeNode(op);
            node.left = left;
            node.right = right;
            return node;
        
    }
    
    boolean isOperator(String s) {
        return "()*/+-".indexOf(s)!=-1;
    }
    boolean canExecute(String op1, String op2) {
        if ("(".equals(op2)) {
            return false;
        }
        if ("*/".indexOf(op1)!=-1 && "+-".indexOf(op2)!=-1){
            return false;
        }
        return true;
    }
    
    public void testSample() {
    	String[] expression = new String[]{"2","*","6","-","1"};
    	assertEquals("-", this.build(expression).symbol);
    }
}
