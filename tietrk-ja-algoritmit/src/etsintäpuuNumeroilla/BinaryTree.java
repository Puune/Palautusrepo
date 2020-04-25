/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package etsintäpuuNumeroilla;

import javafx.scene.Parent;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

    private Node root;
    
    public BinaryTree(int rootValue) {
        root = new Node(rootValue);
    }

    public BinaryTree(int rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    }
    
    
    /**
     * Insert new value, client will get promted to navigate downwards the tree
     * @param aData
     */
    public void insert(int aData){    	
    	BinaryTree left = root.left();
    	BinaryTree right = root.right();

    	if(aData>root.getData()) {
    		if(right==null) {
    			root.setRight(new BinaryTree(aData));
    		} else 
    			right.insert(aData);
    	} else if (aData<root.getData()) {
    		if(left==null) {
    			root.setLeft(new BinaryTree(aData));
    		} else 
    			left.insert(aData);
    	} else {
    		System.out.println("Error, bad input");
    	}
    	
    }
    
    /**
     * Find a node in the tree
     * @param aData
     * @return node {@link BinaryTree}
     */
    public BinaryTree find(int aData){
    	
    	BinaryTree res = null;
    	
        if(root!=null) {
        	System.out.println("testataan " + root.getData());
        	if(root.getData() == aData)
        		res = this;
        
        	if(root.left()!=null  && res == null) 
        		res = root.left().find(aData);
        	
        	if(root.right()!=null && res == null)
        		res = root.right().find(aData);
        }
    	
        return res;
    }
    
 
    private void transplant(Node parent, Node u, Node v) {
    	if(parent==null) {
    		u = v;
    	} else if (u == parent.left().root) {
    		parent.left().root = v;
    	} else {
    		parent.right().root = v;
    	}
    }
    
    
    public BinaryTree delete(int aData, BinaryTree node) {
    	//check if to-be-deleted is this
    	if(this.root.getData()==aData) {
    		Node originalParent = node.root;
    	
    		if(root.left()==null) {
    			transplant(node.root, this.root, root.right().root);
    		} else if(root.right()==null) {
    			transplant(node.root, this.root, root.left().root);
    		} else {
    			Node minimum = this.root.right().root;
    			Node minParent = this.root;
    			while(minimum.left()!=null) {
    				minParent = minimum;
    				minimum = root.left().root;
    			}
    			if(root.right().root != minimum && root.left().root != minimum) {
    				transplant(minParent, minimum, minimum.right().root);
    				minimum.right().root = this.root;
    				originalParent = minimum;
    			}
    			transplant(node.root, this.root, minimum);
    			minimum.setLeft(this.root.left());
    			originalParent = minimum;
    		}
    		
    		return null;
    		
    	} else {
    		//not target node
    		if(root.left() != null)
    			root.setLeft(root.left().delete(aData, this));
    		if(root.right() != null)
    			root.setRight(root.right().delete(aData, this));
    		
    		return this;
    	}
    }
    
    
    public int getHeight() {
    	int leftHeight;
    	int rightHeight;
    	
    	if(root.left()!=null) {
    		leftHeight = root.left().getHeight();
    		leftHeight++;
    	}	else 
    		leftHeight = 0;
    	
    	if(root.right()!=null) {
    		rightHeight = root.right().getHeight();
    		rightHeight++;
    	} else
    		rightHeight = 0;
    	    	
    	return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
    
    
    public boolean isBalanced(BinaryTree tree) {
    	return isBalancedRecursive(tree, -1).isBalanced;
    }
    
    private BalResult isBalancedRecursive(BinaryTree tree, int depth) {
    	BalResult leftSubtree;
    	BalResult rightSubtree;
    	System.out.println(root.getData());
    	if(tree==null) {
    		return new BalResult(true, -1);
    	}
    	
    	if(root.left()!=null)
    		leftSubtree = root.left().isBalancedRecursive(root.left(), depth+1);
    	else
    		leftSubtree = new BalResult(true, -1);
    	
    	if(root.right()!=null)
    		rightSubtree = root.right().isBalancedRecursive(root.right(), depth +1);
    	else
    		rightSubtree = new BalResult(true, -1);
    	
    	boolean isBalanced = Math.abs(leftSubtree.height - rightSubtree.height) <= 1;
    	boolean subtreesAreBalanced = leftSubtree.isBalanced && rightSubtree.isBalanced;
    	int height = rightSubtree.height >= leftSubtree.height ? rightSubtree.height+1 : leftSubtree.height+1;
    	return new BalResult(isBalanced && subtreesAreBalanced, height);
    }
    class BalResult {
    	private boolean isBalanced;
    	private int height;
    	
    	private  BalResult(boolean isBalanced, int height) {
    		this.isBalanced = isBalanced;
    		this.height = height;
    	}
    	
    	public boolean getBalanced() { return isBalanced; } 
    }
    
    
    public int binarySearch(int target) {
    	
    	if(root.getData()==target) {
    		System.out.println("-> this");
    		return this.root.getData();
    	} else if(root.getData()<target) {
    		System.out.println("-> right");
    		return root.right().binarySearch(target);
    	} else if(root.getData()>target) {
    		System.out.println("-> left");
    		return root.left().binarySearch(target);
    	}
    	return 0;
    }
    
    
    public void preOrder() {
        if (root != null) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(root.getData() + "    (");
        	if(root.left()!=null)
        		sb.append("left: " + root.left().root.getData());
        	else
        		sb.append("left: null" );
        	sb.append(" <<>> ");
        	if(root.right()!=null)
        		sb.append("right: " + root.right().root.getData());
        	else
        		sb.append("right: null");
        	sb.append(")");
        	
        	System.out.println(sb.toString());
            if (root.left() != null) // p��seeek�� vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // p��seek�� oikealle?
                root.right().preOrder();
        }
    }
    
    public void innerOrder() {
    	if(root != null) {
    		if(root.left() != null) {
    			root.left().innerOrder();
    		}
    		System.out.println(root.getData());
    		if(root.right() != null) {
    			root.right().innerOrder();
    		}
    	}
    }
  
    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
}
