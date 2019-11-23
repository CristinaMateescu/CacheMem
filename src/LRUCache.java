
import java.util.ArrayList;

/**
 *
 * @author Cristina-Ramona
 */
public class LRUCache implements Cache {

    ArrayList<Subscriptie> cache;

    
    public LRUCache() {
        this.cache = new ArrayList<>();
    }

    @Override
    public void add(Subscriptie sub) {
        cache.add(sub);

    }

    @Override
    public void remove() {
        int min = cache.get(0).timestamp;
        int index_min = 0;
        for (int i = 0; i <= cache.size() - 1; i++) {
            if (cache.get(i).timestamp < min) {
                min = cache.get(i).timestamp;
                index_min = i;
            }
        }
        cache.remove(index_min);
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
