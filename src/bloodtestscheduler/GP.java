package bloodtestscheduler;

/**
 *
 * @author saboteur
 */
public class GP extends Person { // GP class extends Person 
    
    private String specialization; // GP specialization

    // Constructor 
    public GP(String name, int age, String gender, String specialization) {
        super(name, age, "N/A", gender); // GP does not need priority
        this.specialization = specialization;
    }

    // Getter for specialization
    public String getSpecialization() {
        return specialization;
    }

    // Setter for specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // return GP details
    @Override
    public String toString() {
        return name + " (" + gender + ", " + specialization + ")";
    }
}