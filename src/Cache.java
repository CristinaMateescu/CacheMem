
/**
 *
 * @author Cristina-Ramona
 */
public interface Cache {

    /**
     * Adauga un element in Cache
     * @param sub O Subscriptie
     */
    public void add(Subscriptie sub);

    /**
     * Elimina un element din cache
     */
    public void remove();

    /**
     * Returneaza true daca Obiectul exista in cache
     * @param nume  nume Obiect
     * @return true daca Obiectul exista in Cache
     */
    public boolean contine(String nume);

    /**
     * Returneaza numarul de elemente din cache
     * @return dimensiune cache 
     */
    public int dimensiune();

    /**
     * Elimina un obiect cu un nume dat
     * @param nume  nume Obiect
     */
    public void elimina_element(String nume);

    /**
     * Returneaza o referinta la o subscriptie cu nume dat
     * @param nume  nume Obiect
     * @return referinta la o subscriptie cu un nume dat
     */
    public Subscriptie getElement(String nume);
}
