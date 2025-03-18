package bloodtestscheduler;

import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author saboteur
 */

public class Patient extends Person implements Comparable<Patient> { // Automatically orders patients on the basis of urgency, age, and hospital status
    
    private boolean fromHospital; // check if patient is from hospital
    private String assignedGP; // assigned GP to patient
    private String priority; // assigning a patient their priority
   
    public static PriorityQueue<Patient> queue = new PriorityQueue<>(); // used a priority queue to store all patients and sorted by urgency and age
    public static Queue<Patient> noShowList = new LinkedList<>();  // Changed from Stack to Queue to maintain FIFO order
    private static Queue<String> patientHistory = new LinkedList<>(); // Stores processed patient history, using the same FIFO method
    
    public Patient(boolean fromHospital, String name, int age, String priority,String gender, String assignedGP) {
        super(name, age, gender);
        this.priority = priority;
        this.fromHospital = fromHospital;
        this.assignedGP = assignedGP;
    }

    public boolean isFromHospital() {
        return fromHospital;
    }
    
    public String getPriority() { // Getter for priority
        return priority;
    }

    public void setPriority(String priority) { // Setter for priority
        this.priority = priority;
    }
    
    @Override
    public int compareTo(Patient other) { // compares the patients to determine who should be processed first
            
        // priority order -> urgent > medium > low
        int priorityOrder = getPriorityValue(this.priority) - getPriorityValue(other.priority);
        if (priorityOrder != 0) {
            return -priorityOrder;
        } 
        int ageOrder = other.age - this.age; // if priority is the same, it checks the age. This ensures older patients are treated first.
        if (ageOrder != 0) {
            return ageOrder;
        }

        // if both age and priority are the same, then hospital patients are given the next preference
        if (this.fromHospital && !other.fromHospital) return -1;
        if (!this.fromHospital && other.fromHospital) return 1;

        return 0; // if all criteria are the same
    }
    
    // using integer for easy priority comparison
    private int getPriorityValue(String priority) { // implemented switch case here to make it easy for comparison
        switch (priority.toLowerCase()) {        
            case "urgent": 
                return 3;
                
            case "medium": 
                return 2;
                
            case "low":
                return 1;
                
            default: 
                return 0; // should not happen, but if the field is empty then this would be returned and gives this patient the last preference
        }
    }

    public static void addPatient(Patient p) {
        queue.add(p); // add a patient to the priority queue
    }

    public static Patient getNextPatient() {
        return queue.poll(); // pick the highest/next priority patient to be processed, and remove from the list
    }
    
    public String getAssignedGP() {
        return assignedGP;
    }

    public static void markNoShow(Patient p) {
        if (noShowList.size() >= 5) {
            noShowList.poll(); // remove the oldest no-show patient (FIFO order)
        }
        noShowList.add(p); // Add the new no-show patient at the end
    }

    // adding patient to history after they processed
    public static void saveToHistory(Patient p) {
        patientHistory.add("Name: " + p.getName() + ", Age: " + p.getAge() + ", Priority: " + p.getPriority() + ", GP: " + p.getAssignedGP());
    }

    // get patient history in FIFO order
    public static String getPatientHistory() {
        if (patientHistory.isEmpty()) {
            return "No history.";
        }

        StringBuilder historyText = new StringBuilder("Patient History:\n\n");
        for (String patientDetails : patientHistory) {
            historyText.append(patientDetails).append("\n--------------------------------------------\n");
        }
        return historyText.toString();
    }

    // clear patient history queue
    public static void clearPatientHistory() {
        patientHistory.clear();
    }

    @Override
    public String toString() {
        return name + " (" + gender + ", " + priority + ", Age: " + age + ", Hospital: " + fromHospital + ", GP: " + assignedGP + ")"; // return in this order
    }
}