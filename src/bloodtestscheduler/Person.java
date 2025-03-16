package bloodtestscheduler;

/**
 *
 * @author saboteur
 */

public abstract class Person { // this is an abstract class to represent a base class for patient and gp class
    
    // initializing variables, stores the person's name, age, gender
    protected String name; 
    protected int age;
    protected String gender; 
   
    // Constructors
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        
    }

    // Setters and Getters 
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getGender() {
        return gender;
    }

}
