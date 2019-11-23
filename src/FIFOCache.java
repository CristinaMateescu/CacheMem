
import java.util.ArrayList;

/**
 *
 * @author Cristina-Ramona
 */
public class FIFOCache implements Cache {

    ArrayList<Subscriptie> cache;

    
    public FIFOCache() {
        this.cache = new ArrayList<>();

    }

    @Override
    public void add(Subscriptie sub) {
        cache.add(sub);
    }

    @Override
    public void remove() {
        cache.remove(0);

    }

    @Override
    public boolean contine(String nume) {
        return cache.stream().anyMatch((s) -> (s.name.equals(nume)));

    }

    @Override
    public void elimina_element(String nume) {
        int index = 0;

        for (Subscriptie s : cache) {
            if (s.name.equals(nume)) {
                break;
            }
            index++;
        }

        cache.remove(index);
    }

    @Override
    public int dimensiune() {
        return cache.size();
    }

    @Override
    public Subscriptie getElement(String nume) {
        for (Subscriptie s : cache) {
            if (s.name.equals(nume)) {
                return s;
            }
        }
        return null;
    }

}
