/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package etsint�puu;

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

                        System.out.println("\n\t\t\t1. Lis�� avain.");
                        System.out.println("\t\t\t2. Etsi avaimella.");
                        System.out.println("\t\t\t3. K�y puu l�pi esij�rjestyksess�.");
                        System.out.println("\t\t\t4. lopetus ");
                        System.out.print("\n\n"); // tehd��n tyhji� rivej�
                        select = Lue.merkki();
                        switch (select) {
                        case '1':
                            System.out.println("Anna uusi avain (merkkijono)");
                            data = new String(Lue.rivi());
                            
                            if(tree == null) {
                            	tree = new BinaryTree(data);
                            } else {
                            	tree.insert(data);
                            }
                            break;
                        case '2':                           
                                System.out.println("Anna etsitt�v� avain (merkkijono)");
                                data = Lue.rivi();
                                if (tree.find(data)!=null){
                                    System.out.println("Avain l�ytyi.");
                                }
                                else
                                    System.out.println("Avainta ei l�ytynyt.");
                                                           
                            break;
                        case '3':
                            tree.preOrder();
                            char h = Lue.merkki(); // pys�ytet��n kontrolli
                            break;
                        case '4':
                            break;
                        }
                }
                while (select != '4');
        }
//printMenu loppuu ----------------------------------------------------------------
}

