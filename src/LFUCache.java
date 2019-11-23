
import java.util.ArrayList;

/**
 *
 * @author Cristina-Ramona
 */
public class LFUCache implements Cache {

    ArrayList<Subscriptie> cache;

    
    public LFUCache() {
        this.cache = new ArrayList<>();
    }

    @Override
    public void add(Subscriptie sub) {
        cache.add(sub);

    }

    @Override
    public void remove() {
        int min = cache.get(0).accesari;
        int index_min = 0;
        for (int i = 0; i <= cache.size() - 1; i++) {
            if (cache.get(i).accesari < min) {
                min = cache.get(i).accesari;
                index_min = i;
            }
        }
        Subscriptie sub = cache.get(index_min);
        sub.accesari = 0;
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
        Subscriptie sub = cache.get(index);
        sub.accesari = 0;
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
