/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teht5;

import java.util.LinkedList;

/**
 *
 * @author kamaj
 */
public class Stack {

        ListItem top; // top n‰kyy oletuspakkaukseen
        
        LinkedList<ListItem> ll = new LinkedList<>();

        public Stack() {
//                top = null;
//                size = 0;
        }
        //  palautetaan pino-iteraattori
        public StackIterator iterator() {
            return new StackIterator(this);
        }
        
        // muodostetaan uusi alkio ja vied‰‰n se huipulle
        public void push(String aData) {
        	ll.push(new ListItem(aData));
//                ListItem newItem = new ListItem(); // luodaan uusi lista-alkio
//                newItem.setData(aData);
//                newItem.setLink(top); // kytket‰‰n uusi alkio aikaisempaan huippualkioon
//                top = newItem; // uusi alkio pinon 1:ksi
//                size++;
        }
        // poistetaan alkio pinon huipulta, jos pinossa ei alkioita palautetaan null
        public ListItem pop() {
                ListItem takeAway;
                if (top == null) {
                        takeAway = null; // pino on tyhj‰
                }
                else
                {
                	takeAway = ll.getLast();
                	ll.pop();
                }
                return takeAway;
        }
        // palautetaan pinottujen alkioiden lukum‰‰r‰
        public int getSize() {
                return ll.size();
        }
        // listataan sis‰lt‰‰
        public void printItems() {
                ListItem lPointer = top;
                while (lPointer != null) {
                        System.out.print(lPointer.getData()+", ");
                        lPointer = lPointer.getLink();
                }

        }
}

