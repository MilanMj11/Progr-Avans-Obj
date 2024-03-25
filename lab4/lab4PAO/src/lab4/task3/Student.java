package lab4.task3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable{
    private String fullName;
    private Map<String, Double> courseInformation;
    public Student(){};
    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = new HashMap<>(courseInformation);
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Student clonedStudent = (Student) super.clone();
        clonedStudent.courseInformation = new HashMap<>(this.courseInformation);
        return clonedStudent;
    }

    @Override
    public String toString(){
        return "Student fullname: " + fullName + '\'' + ", courseInformation: " + courseInformation;
    }

    public Map<String,Double> getCourseInformation(){
        return this.courseInformation;
    }

    public void updateCourseInformation(String materie, Double nota){
        this.courseInformation.put(materie,nota);
    }
}