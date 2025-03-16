package bloodtestscheduler;

/**
 *
 * @author saboteur
 */
public class GP extends Person { // GP class extends Person 
    
    private String specialization; // GP specialization
    private static GP[] gpList = {
        new GP("Dr. Smith", 45, "Male", "Cardiology"),
        new GP("Dr. Johnson", 50, "Female", "Neurology"),
        new GP("Dr. Lee", 40, "Male", "Pediatrics"),
        new GP("Dr. Patel", 38, "Female", "General Practice"),
        new GP("Dr. Adams", 42, "Male", "Orthopedics")        
    };
    
    // Constructor 
    public GP(String name, int age, String gender, String specialization) {
        super(name, age, "N/A", gender); // GP does not need priority field
        this.specialization = specialization;
    }

    // Getter and Setter
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    // Return GP details
    @Override
    public String toString() {
        return name + " (" + gender + ", " + specialization + ")";
    }

    // Return the list of all GPs
    public static GP[] getGPList() {
        return gpList;
    }
}