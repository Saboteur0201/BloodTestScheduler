package bloodtestscheduler;

/**
 *
 * @author saboteur
 */
public class Patient extends Person
implements Comparable<Patient> // Automatically orders patients on the basis of urgency, age and hospital status
{
    
    private boolean fromHospital;

    public Patient(boolean fromHospital, String name, int age, String priority) {
        super(name, age, priority);
        this.fromHospital = fromHospital;
    }       
    
    public boolean isFromHospital(){
        return fromHospital;
    }
    
    @Override
    public int compareTo(Patient other) {
        
        // priority order -> urgen > medium > low
        int priorityOrder = getPriorityValue(this.priority) - getPriorityValue(other.priority);
        int ageOrder = other.age - this.age;
        if (priorityOrder != 0) return -priorityOrder; 
        if (ageOrder != 0) return ageOrder;

        // giving hospital patients priorty
        if (this.fromHospital && !other.fromHospital) return -1;
        if (!this.fromHospital && other.fromHospital) return 1;

        return 0;
    }
    
    private int getPriorityValue(String priority) {
        switch (priority.toLowerCase()) {
            case "urgent": return 3;
            case "medium": return 2;
            case "low": return 1;
            default: return 0;
        }
    }

    @Override
    public String toString() {
        return name + " (" + priority + ", Age: " + age + ", Hospital: " + fromHospital + ")";
    }
}
