/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package etsint‰puu;

/**
 *
 * @author kamaj
 */
public class BinaryTree {

    private Node root;
    
    public BinaryTree(String rootValue) {
        root = new Node(rootValue);
    }

    public BinaryTree(String rootValue, BinaryTree left, BinaryTree right){
        root = new Node(rootValue, left, right);
    }
    
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
            if (root.left() != null) // p‰‰seeek‰‰ vasemmalle?
                root.left().preOrder();
            if (root.right() != null) // p‰‰seek‰‰ oikealle?
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
