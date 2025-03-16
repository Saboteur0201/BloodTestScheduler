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
    private String priority;
    
    public static PriorityQueue<Patient> queue = new PriorityQueue<>(); // used a priority queue to store all patients and sorted by urgency and age
    public static Queue<Patient> noShowList = new LinkedList<>();  // i used the linked list to store the list of no-show patients 

    public Patient(boolean fromHospital, String name, int age, String priority,String gender, String assignedGP) {
        super(name, age,gender);
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
        int ageOrder = other.age - this.age; // if priorty is same, it checks the age. this makes it so that the elderly patients come first
        if (priorityOrder != 0) return -priorityOrder; 
        if (ageOrder != 0) return ageOrder;

        // if both age and priority are the same, then hospital patients are given the next preference
        if (this.fromHospital && !other.fromHospital) return -1;
        if (!this.fromHospital && other.fromHospital) return 1;

        return 0; // if all criteria is the same
    }
    
    // using integer for easy priority comparision
    private int getPriorityValue(String priority) {
        switch (priority.toLowerCase()) {        
            case "urgent": 
                return 3;
                
            case "medium": 
                return 2;
                
            case "low":
                return 1;
                
            default: 
                return 0; // should not happen, but if the field is empty then this would be returned
        }
    }

    public static void addPatient(Patient p) {
        queue.add(p); // add a patient to the priortu queue
    }

    public static Patient getNextPatient() {
        return queue.poll(); // pick the highest/next priority patient to be processed, and remove from the list
    }
    
     public String getAssignedGP() {
        return assignedGP;
    }

    public static void markNoShow(Patient p) {
        if (noShowList.size() >= 5) {
            noShowList.poll(); // remove last no-show (oldest)
        }
        noShowList.add(p);
    }

    @Override
    public String toString() {
        return name + " (" + gender + "," + priority + ", Age: " + age + ", Hospital: " + fromHospital + ", GP: " + assignedGP + ")"; // return in this order
    }
}