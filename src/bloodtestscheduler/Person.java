package bloodtestscheduler;

/**
 *
 * @author saboteur
 */

public abstract class Person {
    
    protected String name; // initialising variables
    protected int age; // initialising variables
    protected String priority; // initialising variables
    protected String gender;

    // Constructors
    public Person(String name, int age, String priority, String gender) {
        this.name = name;
        this.age = age;
        this.priority = priority;
        this.gender = gender;
        
    }

    // Setters and Getters 
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPriority() {
        return priority;
    }
    
    public String getGender() {
        return gender;
    }

}
