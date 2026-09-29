package patient_intake;

public class Person {
    protected String firstName = "";
    protected String lastName = "";
    protected int age;
    private String pid;
    private String name;
    private String chiefComplaint;
    private int triageLevel;

    public Person(String firstName, String lastName, int age) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.age = age;
        // TODO REQUIRED: Store the shared first name, last name, and age.
    }

    public Person(String pid, String name, String chiefComplaint, int triageLevel) {
        this.pid = pid;
        this.name = name;
        this.chiefComplaint = chiefComplaint;
        this.triageLevel = triageLevel;
    }
}