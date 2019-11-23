
import java.util.ArrayList;

/**
 *
 * @author Cristina-Ramona
 */
public class Memory {

    ArrayList<Subscriptie> memory;

    
    public Memory() {
        this.memory = new ArrayList<>();
    }

    /**
     * Returneaza true daca obiectul exista in memorie
     * @param nume  nume Obiect
     * @return true daca obiectul exista in memorie
     */
    public boolean contine(String nume) {
        return memory.stream().anyMatch((s) -> (s.name.equals(nume)));
    }

    /**
     * Suprascriere Obiect in Memorie
     * @param nume  nume Obiect
     * @param contor_basic  nr. accesari tip Basic
     * @param contor_premium  nr. accesari tip Premium
     */
    public void suprascrie(String nume, int contor_basic, int contor_premium) {
        int index = 0;

        for (Subscriptie s : memory) {
            if (s.name.equals(nume)) {
                break;
            }
            index++;
        }

        if (contor_premium != 0) {
            Subscriptie sub = new Premium(contor_premium, contor_basic, nume);
            memory.set(index, sub);
        } else {
            Subscriptie sub = new Basic(contor_basic, nume);
            memory.set(index, sub);
        }
    }

    /**
     * Adaugare element in memorie
     * @param s  subscriptie
     */
    public void adauga(Subscriptie s) {
        memory.add(s);
    }

    /**
     * Returneaza referinta la un Obiect cu nume dat
     * @param nume = nume Obiect
     * @return referinta la un Obiect cu un nume dat
     */
    public Subscriptie getElement(String nume) {
        for (Subscriptie s : memory) {
            if (s.name.equals(nume)) {
                return s;
            }
        }
        return null;
    }
}
