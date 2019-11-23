
/**
 *
 * @author Cristina-Ramona
 */
public class Basic extends Free {

   
    protected int Basic_contor;

    
    public Basic() {
        Basic_contor = 0;
    }

    /**
     *
     * @param Basic_contor  nr. accesari Basic
     * @param name  nume obiect
     */
    public Basic(int Basic_contor, String name) {
        this.Basic_contor = Basic_contor;
        this.name = name;
    }

    /**
     *
     * @return Tipul Subcriptiei 
     */
    @Override
    public String getType() {
        if (Basic_contor != 0) {
            Basic_contor = Basic_contor - 1;
            return "Basic";
        }
        return super.getType();
    }

}
