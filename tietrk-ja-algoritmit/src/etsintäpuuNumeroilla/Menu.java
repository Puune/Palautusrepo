/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package etsintäpuuNumeroilla;

import lajitteludemo.Lue;

/**
 *
 * @author kamaj
 */
public class Menu {
//main alkaa-----------------------------------------------------------------------------
        public static void main(String[] args) {

                        printMenu();

        }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
        private static void printMenu() {
                char select;
                BinaryTree tree = null;
                String data;
                do {

                        System.out.println("\n\t\t\t1. Lisää avain.");
                        System.out.println("\t\t\t2. Etsi avaimella.");
                        System.out.println("\t\t\t3. Binaarihaku.");
                        System.out.println("\t\t\t4. Poista avain.");
                        System.out.println("\t\t\t5. Hae avain & kerro korkeus");
                        System.out.println("\t\t\t6. Testaa puun tasapainoisuus");
                        System.out.println("\t\t\t7. Käy puu läpi esijärjestyksessä.");
                        System.out.println("\t\t\t8. Käy läpi sisäjärjestyksessä.");
                        System.out.println("\t\t\t9. lopetus ");
                        System.out.print("\n\n"); // tehdään tyhjiä rivejä
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna uusi avain (numero)");
//                            data = new String(Lue.rivi());
                            int aData = Lue.kluku();
                            
                            if(tree == null) {
                            	tree = new BinaryTree(aData);
                            } else {
                            	tree.insert(aData);
                            }
                            break;
                        case '2':                           
                                System.out.println("Anna etsittävä avain (numero)");
//                                data = Lue.rivi();
                                aData = Lue.kluku();
                                
                                if (tree.find(aData)!=null){
                                    System.out.println("Avain löytyi.");
                                }
                                else
                                    System.out.println("Avainta ei löytynyt.");
                                                           
                            break;
                        case '3':
                        	System.out.println("Anna etsittävä avain");
                        	aData = Lue.kluku();
                        	int res = tree.binarySearch(aData);
                        	if(res!=0) { System.out.println("Löytyi: " + res); }
                        	break;
                        case '4':
                        	System.out.println("Anna poistettava avain (numero");
                        	aData = Lue.kluku();
                        	tree.delete(aData, null);
                        	break;
                        case '5':
                        	System.out.println("Anna avain");
                        	aData = Lue.kluku();
                        	BinaryTree bt = tree.find(aData);
                        	int height = bt.getHeight();
                        	System.out.println("Solmun korkeus on: " + height);
                        	break;
                        case'6':
                        	boolean balanced = tree.isBalanced(tree);
                        	System.out.println("Puu on tasapainossa: " + balanced);
                        	break;
                        case '7':
                            tree.preOrder();
                            char h = Lue.merkki(); // pysäytetään kontrolli
                            break;
                        case '8':
                        	tree.innerOrder();
                        	char i = Lue.merkki();
                        	break;
                        case '9':
                            break;
                        }
                }
                while (select != '6');
        }
//printMenu loppuu ----------------------------------------------------------------
}

