package bloodtestscheduler;

/**
 *
 * @author saboteur
 */

public abstract class Person {
    protected String name;
    protected int age;
    protected String priority;

    public Person(String name, int age, String priority) {
        this.name = name;
        this.age = age;
        this.priority = priority;
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
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPriority() {
        return priority;
    }
    
    
}
