package lint;

import junit.framework.TestCase;

public class RemoveNode  extends TestCase{
	public TreeNode removeNode(TreeNode root, int value) {
        //search the value
        TreeNode parent=root;
        TreeNode curr = root;
        while(curr!=null && curr.val!=value ) {
            if (curr.val<value) {
                parent = curr;
                curr = curr.right;
            }
            else {
                parent = curr;
                curr = curr.left;
            }
        }
        if (curr == null) {
            return root;
        }
    
        //find curr's first successor     
        TreeNode toDelete = curr;
        if (curr.left!=null && curr.right!=null) {
            toDelete = curr.right;
            while(toDelete.left!=null) {
                parent = toDelete;
                toDelete = toDelete.left;
            }
            curr.val = toDelete.val;
            toDelete.val = value;
        }
        if (parent.val == value) {
            if (parent.left!=null) {
            	return parent.left;
            }
            else {
            	return parent.right;
            }
        }
        
        if (parent.left!=null && parent.left.val==value) {
            if (toDelete.left!=null) {
                parent.left = toDelete.left;
            }
            else {
                parent.left = toDelete.right;
            }
        }
        else if (parent.right!=null && parent.right.val==value) {
            if (toDelete.left!=null) {
                parent.right = toDelete.left;
            }
            else {
                parent.right = toDelete.right;
            }
        }
        return root;
    
    }
	
	public void testSample() {
		TreeNode root = new TreeNode(5);
		assertNull(this.removeNode(root, 5));
		TreeNode left = new TreeNode(1);
		root.left = left;
		assertTrue(this.removeNode(root, 5).val==1);
		
	}
}
