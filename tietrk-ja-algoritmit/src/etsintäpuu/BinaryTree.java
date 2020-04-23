/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package etsintäpuu;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

    public Node root;
    
    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }

    public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    }
    
    
    public BinaryTree delete(int aData) {
    	//check if to-be-deleted is this
    	if(this.root.getData().equals(aData)) {

    		if(root.left()==null && root.right()==null) {
    			return null;
    		} else {
    			Node parent = root;
    			Node node = root;
    			while(node.left()!=null) {
    				parent = node;
    				node = node.left().root;
    			}
    			if(node.right()==null) {
    				parent.setLeft(null);
    				return new BinaryTree(node.getData(), node.left(), node.right());
    			} else {
    				parent.setLeft(node.right());
    				return new BinaryTree(node.getData(), node.left(), node.right());
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
    
    
    /**
     * Insert new value, client will get promted to navigate downwards the tree
     * @param aData
     */
    public void insert(String aData){    	
    	BinaryTree left = root.left();
    	BinaryTree right = root.right();
    	
    	//onko lehti
    	if(left==null && right==null) {
    		System.out.println("Lehti, aseta uusi solmu o: oikealle, v: vasemmalle..");
    		char select = Lue.merkki();
    		
    		if(select == 'o') {
    			setRight(new BinaryTree(aData));
    		} else if (select == 'v') {
    			setLeft(new BinaryTree(aData));
    		}
    	} else {
    		//valitse haara
    		System.out.println("Mene oikealle tai vasemmalle o: oikealle, v: vasemmalle");
    		char select = Lue.merkki();
    		
    		if(select == 'o') {
    			if(right==null) {
    				System.out.println("Ei solmua oikealla, asetetaan..");
    				setRight(new BinaryTree(aData));
    			} else {
    				root.right().insert(aData);
    			}
    		} else if(select == 'v') {
     			if(left==null) {
    				System.out.println("Ei solmua vasemmalla, asetetaan..");
    				setLeft(new BinaryTree(aData));
    			} else {
    				root.left().insert(aData);
    			}	
    		}
    	}
    }
    
    public int getHeight() {
    	int top = 0;
    	int current = 0;
    	
    	if(root.left()!=null) {
    		root.left().getHeight();
    	}
    	
    	if(root.right()!=null) {
    		root.right().getHeight();
    	}
    }
    
    /**
     * Find a node in the tree
     * @param aData
     * @return node {@link BinaryTree}
     */
    public BinaryTree find(String aData){
    	
    	BinaryTree res = null;
    	
        if(root!=null) {
        	System.out.println("testataan " + root.getData());
        	if(root.getData().equals(aData))
        		res = this;
        
        	if(root.left()!=null  && res == null) 
        		res = root.left().find(aData);
        	
        	if(root.right()!=null && res == null)
        		res = root.right().find(aData);
        }
    	
        return res;
    }
    
    public void preOrder() {
        if (root != null) {
            System.out.println(root.getData()+',');
            if (root.left() != null) // p��seeek�� vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // p��seek�� oikealle?
                root.right().preOrder();
        }

    }
  
    public void setLeft(BinaryTree tree) {
        root.setLeft(tree);
    }

    public void setRight(BinaryTree tree) {
        root.setRight(tree);
    }
}
