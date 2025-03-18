package bloodtestscheduler;

/**
 *
 * @author saboteur
 */

public class GP extends Person { // GP class extends Person 
    
    private String specialization; // GP specialization
    private static GP[] gpList = {
        new GP("Dr. Smith", 45, "Female", "Cardiology"),
        new GP("Dr. Johnson", 50, "Male", "Neurology"),
        new GP("Dr. Lee", 40, "Female", "Pediatrics"),
        new GP("Dr. Patel", 38, "Male", "General Practice"),
        new GP("Dr. Adams", 42, "Male", "Orthopedics")        
    };
    
    // Constructor 
    public GP(String name, int age, String gender, String specialization) {
        super(name, age, gender); // initially I had this set to "N/A" to get it working, now that it functions I have moved the priorty attribute to another class
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