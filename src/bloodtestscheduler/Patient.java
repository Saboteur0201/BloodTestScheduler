package bloodtestscheduler;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author saboteur
 */

public class Patient extends Person implements Comparable<Patient> { // Automatically orders patients on the basis of urgency, age, and hospital status
    private boolean fromHospital;

    private static PriorityQueue<Patient> queue = new PriorityQueue<>();
    private static Queue<Patient> noShowList = new LinkedList<>();
    
    public Patient(boolean fromHospital, String name, int age, String priority) {
        super(name, age, priority);
        this.fromHospital = fromHospital;
    }       
    
    public boolean isFromHospital() {
        return fromHospital;
    }
    
    @Override
    public int compareTo(Patient other) {
        // priority order -> urgent > medium > low
        int priorityOrder = getPriorityValue(this.priority) - getPriorityValue(other.priority);
        int ageOrder = other.age - this.age;
        if (priorityOrder != 0) return -priorityOrder; 
        if (ageOrder != 0) return ageOrder;

        // giving hospital patients priority
        if (this.fromHospital && !other.fromHospital) return -1;
        if (!this.fromHospital && other.fromHospital) return 1;

        return 0;
    }
    
    private int getPriorityValue(String priority) {
        switch (priority.toLowerCase()) {        
            case "urgent": 
                return 3;
                
            case "medium": 
                return 2;
                
            case "low":
                return 1;
                
            default: 
                return 0;
        }
    }

    public static void addPatient(Patient p) {
        queue.add(p); // add a patient to queue
    }

    public static Patient getNextPatient() {
        return queue.poll(); // pick the highest priority patient
    }

    public static void markNoShow(Patient p) {
        if (noShowList.size() >= 5) {
            noShowList.poll(); // remove last no-show (oldest)
        }
        noShowList.add(p);
    }

    @Override
    public String toString() {
        return name + " (" + priority + ", Age: " + age + ", Hospital: " + fromHospital + ")";
    }
}