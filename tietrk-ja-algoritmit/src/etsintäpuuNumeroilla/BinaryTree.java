/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package etsintäpuuNumeroilla;

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
    
    
    public BinaryTree delete(int aData) {
    	//check if to-be-deleted is this
    	if(this.root.getData()==aData) {

    		if(root.left()==null && root.right()==null) {
    			return null;
    		} else {
    			Node parent = root;
    			Node up = root;
    			Node node = root;
    			
    			if(node.right()!=null) {
    				node = node.right().root;
    			}
    			
    			while(node.left()==null) {
    				node = node.right().root;
    			}
    			
    			while(node.left()!=null) {
    				up = node;
    				node = node.left().root;
    			}
    			System.out.println("parent: " + parent.getData());
    			System.out.println("up: " + up.getData());
    			System.out.println("node: " + node.getData());
    			System.out.println("parent is up: " + parent.equals(up));
    			if(node.right()==null) {
    				up.setLeft(null);
    				return new BinaryTree(node.getData(), parent.left(), parent.right());
    			} else {
    				up.setLeft(node.right());
    				return new BinaryTree(node.getData(), parent.left(), parent.right());
    			}
    		}
    		
    	} else {
    		//not target node
    		if(root.left() != null)
    			root.setLeft(root.left().delete(aData));
    		if(root.right() != null)
    			root.setRight(root.right().delete(aData));
    		
    		return this;
    	}
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
