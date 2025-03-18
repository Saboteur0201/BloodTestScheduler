package bloodtestscheduler;

/**
 *
 * @author saboteur
 */

public class BTS {
    
    public static void main(String[] args) {
      
        System.out.println("Starting....."); // display confirmation
        GUI gui = new GUI();
        hardCoded(gui); // calling the function
        gui.setVisible(true); // initialzing GUI 
        
        System.out.println("\nWelcome!"); // terminal system confirmation
        
        
    }
    
    // the below function are test codes, where details of some patients are hard coded and load upon system start
    private static void hardCoded(GUI gui) { 
        Patient.addPatient(new Patient(true, "Emma Walker", 65, "Urgent", "Female", "Dr. Smith (Cardiology)")); 
        Patient.addPatient(new Patient(true, "Diego Fernández", 60, "Low", "Male", "Dr. Adams (Orthopedics)")); 
        Patient.addPatient(new Patient(false, "Daniel Thompson", 45, "Medium", "Male", "Dr. Johnson (Neurology)"));
        Patient.addPatient(new Patient(true, "Ethan Carter", 75, "Low", "Male", "Dr. Patel (General Practice)"));
        Patient.addPatient(new Patient(false, "Yusuf Abbas", 70, "Medium", "Male", "Dr. Patel (General Practice)"));
        Patient.addPatient(new Patient(false, "Sophia Reynolds", 30, "Urgent", "Female", "Dr. Lee (Pediatrics)"));
        Patient.addPatient(new Patient(true, "Jack Harrison", 50, "Medium", "Male", "Dr. Adams (Orthopedics)"));
        Patient.addPatient(new Patient(false, "Margaret Dawson", 80, "Low", "Female", "Dr. Patel (General Practice)"));
        Patient.addPatient(new Patient(true, "Tatiana Alves", 36, "Urgent", "Female", "Dr. Adams (Orthopedics)")); 
        Patient.addPatient(new Patient(true, "Lucas Bennett", 55, "Urgent", "Male", "Dr. Johnson (Neurology)"));
        Patient.addPatient(new Patient(true, "Amara Ndlovu", 55, "Medium", "Female", "Dr. Johnson (Neurology)")); 
        Patient.addPatient(new Patient(false, "Olivia Carter", 22, "Medium", "Female", "Dr. Smith (Cardiology)"));
        Patient.addPatient(new Patient(true, "Nathaniel Brooks", 67, "Low", "Male", "Dr. Lee (Pediatrics)")); 
        Patient.addPatient(new Patient(false, "Nour Haddad", 41, "Low", "Male", "Dr. Lee (Pediatrics)")); 
        Patient.addPatient(new Patient(false, "Victoria Hayes", 29, "Urgent", "Female", "Dr. Adams (Orthopedics)"));
        Patient.addPatient(new Patient(true, "Benjamin Walker", 58, "Medium", "Male", "Dr. Smith (Cardiology)"));
        Patient.addPatient(new Patient(false, "Charlotte Evans", 72, "Low", "Female", "Dr. Patel (General Practice)"));
        Patient.addPatient(new Patient(true, "William Foster", 40, "Urgent", "Male", "Dr. Johnson (Neurology)"));
        Patient.addPatient(new Patient(false, "Isabella Romano", 33, "Medium", "Female", "Dr. Lee (Pediatrics)"));
        Patient.addPatient(new Patient(false, "Liam O'Connor", 47, "Urgent", "Male", "Dr. Smith (Cardiology)"));        
        
        gui.updateQueueTable(); // refreshing the table to reflect these changes
        System.out.println("Hardcoded patients loaded"); // terminal confirmation
        
        
    }
    
}
