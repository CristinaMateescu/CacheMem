
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Cristina-Ramona
 */
public class Main {

    /**
     *
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        //Citire date
        Scanner input = new Scanner(new File(args[0]));
        PrintStream fileStream = new PrintStream(args[1]);
        System.setOut(fileStream);
        String cache_type = input.nextLine();

        /**
         * capacity - capacitatea cache-ului 
         * operation_nr - numarul de operatii
         */
        int capacity = input.nextInt();
        int operation_nr = input.nextInt();
        int i;
        input.nextLine();

        //Declarare si initializare : memorie, cache - cu tipul corespunzator
        Memory memory = new Memory();
        Cache cache;

        if (cache_type.equals("FIFO")) {
            cache = new FIFOCache();
        } else if (cache_type.equals("LRU")) {
            cache = new LRUCache();
        } else {
            cache = new LFUCache();
        }

        //Initializare contor (set timestamp)
        int contor = 0;

        //CITIRE OPERATII    
        for (i = 1; i <= operation_nr; i++) {
            String operation = input.nextLine();
            String parts[] = operation.split(" ");
            String nume = parts[1];

            //"ADD"
            //Initializare contoare - nr. de accesari 
            if (parts[0].equals("ADD")) {
                int contor_basic = Integer.parseInt(parts[2]);
                int contor_premium;

                if (parts.length == 4) {
                    contor_premium = Integer.parseInt(parts[3]);
                } else {
                    contor_premium = 0;
                }

                //Daca exista in memorie : suprascriere , eliminare din cache
                if (memory.contine(nume)) {
                    memory.suprascrie(nume, contor_basic, contor_premium);
                    if (cache.contine(nume)) {
                        cache.elimina_element(nume);
                    }
                } 
                //Daca nu exista : creare, initializare si adaugare in memorie
                else {
                    Subscriptie sub;
                    if (parts.length == 4) {
                        sub = new Premium(contor_premium, contor_basic, nume);
                    } else {
                        sub = new Basic(contor_basic, nume);
                    }

                    memory.adauga(sub);
                }
            //"GET"   
            } else {
                
                //Daca exista in cache : afisare
                if (cache.contine(nume)) {
                    Subscriptie sub = cache.getElement(nume);
                    contor++;
                    sub.setTimestamp(contor);
                    System.out.println("0 " + sub.getType());
                } 
                
                //Daca exista doar in memorie : adaugare in cache, afisare
                else if (memory.contine(nume)) {

                    if (cache.dimensiune() == capacity) {
                        cache.remove();
                    }
                    Subscriptie sub = memory.getElement(nume);
                    contor++;
                    sub.setTimestamp(contor);
                    cache.add(sub);
                    System.out.println("1 " + sub.getType());

                }
                
                //Daca nu exista nici in cache nici in memorie
                else {
                    System.out.println("2");
                }
            }
        }
    }
}
