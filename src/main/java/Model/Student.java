package Model;

public class Student {
    // entities
protected int id;
protected String fname;
protected String lname;
protected int age;
protected double gpa;

    public Student(int id, String fname,String lname, int age, String grade) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.gpa = gpa;
    }
}
