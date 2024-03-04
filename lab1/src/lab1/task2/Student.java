package lab1.task2;

public class Student {
    private String name;
    private double grade;

    public Student(){}
    public Student(String name, double grade){
        this.name = name;
        this.grade = grade;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGrade(double grade){
        this.grade = grade;
    }
    public double getGrade(){
        return this.grade;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return "Studentul " + this.name;
    }
}
