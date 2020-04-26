package priorityQueue;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
	//main alkaa-----------------------------------------------------------------------------
    public static void main(String[] args) {

                    printMenu();

    }
//main loppuu --------------------------------------------------------------------------
//printMenu alkaa------------------------------------------------------------------
    private static void printMenu() {
            char select;
            PrioStack stack = new PrioStack();
            String data; // Pinon data-kentt�
            int priority;
            do {

                    System.out.println("\n\t\t\t1. Alkion lisääminen.");
                    System.out.println("\t\t\t2. Alkion poistaminen.");
                    System.out.println("\t\t\t3. Pinon sisältö.");
                    System.out.println("\t\t\t4. Alkioiden lukum��r�.");
                    System.out.println("\t\t\t5. lopetus ");
                    System.out.print("\n\n"); // tehd��n tyhji� rivej�
                    select = Lue.merkki();
                    switch (select) {
                    case '1':
                        System.out.println("Anna alkion sisältö (merkkijono)");
                        data = new String(Lue.rivi());
                        System.out.println("Anna prioriteetti (kokonaisluku)");
                        priority = Lue.kluku();
                        stack.insert(data, priority);
                        break;
                    case '2':
                    	PrioItem item = stack.dequeue();
                        if (item == null)
                            System.out.println("Pino on tyhjä");
                        else
                            System.out.println("Poistettu alkio ja prio..: "+item + "  (" + item.priority() + ")");
                        break;
                    case '3':
                        Iterator<PrioItem> it = stack.iterator();
                        int size = stack.getSize() + 3;
                        while(it.hasNext() && size > 0) {
                        	PrioItem i = it.next();
                        	System.out.println(i + "  (" + i.priority() + ")");
                        	size--;
                        }
                        break;
                    case '4':
                        System.out.println("Lukumäärä = "+stack.getSize());
                        break;
                    case '5':
                        break;
                    }
            }
            while (select != '5');
    }
//printMenu loppuu ----------------------------------------------------------------
}
