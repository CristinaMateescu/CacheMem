
/**
 *
 * @author Cristina-Ramona
 */
public class Premium extends Basic {

    
    protected int Premium_contor;

    public Premium() {
        Premium_contor = 0;
    }

    /**
     * 
     * @param Premium_contor  nr. accesari tip Premium
     * @param Basic_contor  nr. accesari tip Basic
     * @param name nume Obiect
     */
    public Premium(int Premium_contor, int Basic_contor, String name) {
        this.Premium_contor = Premium_contor;
        this.Basic_contor = Basic_contor;
        this.name = name;
    }

    @Override
    public String getType() {
        if (Premium_contor != 0) {
            Premium_contor = Premium_contor - 1;
            return "Premium";
        }
        return super.getType();
    }

}
