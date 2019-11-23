
/**
 *
 * @author Cristina-Ramona
 */
public abstract class Subscriptie {

    /**
     *  
     */
    protected String name;

    protected int timestamp;

    protected int accesari;

    protected Subscriptie() {
        timestamp = 0;
        accesari = 0;
    }

    /**
     * Actualizare timestamp
     * @param timestamp indica ordinea accesarilor 
     */
    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
        this.accesari = this.accesari + 1;
    }


    /**
     *
     * @return tipul subscriptiei
     */
    public abstract String getType();

}
