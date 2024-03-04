package lab1.task2;
import java.security.cert.TrustAnchor;
import java.util.Random;
import java.util.Vector;
public class Course {
    String name;
    double minimumGrade;
    Student[] students;

    public Course(String name, double minimumGrade, Student[] students){
        this.name = name;
        this.minimumGrade = minimumGrade;
        this.students = students;
    }
    public Student choseStudentRandomly(){
        Random rand = new Random();
        int nr = rand.nextInt(this.students.length);
        return this.students[nr];
    }

    public Student[] showAllPassingStudents(){
        Student[] ansList = new Student[100];
        int nr_studenti = 0;
        for(int i=0;i<this.students.length;i++){
            Student currentStudent = this.students[i];
            if(currentStudent.getGrade() >= this.minimumGrade)
                ansList[++nr_studenti] = currentStudent;
        }
        for(int i=1;i<=nr_studenti;i++){
            System.out.println(ansList[i].toString());
        }
        return ansList;
    }

    public boolean isStudentPassing(String nume){
        for(int i=0;i<this.students.length;i++){
            if (this.students[i].getName() == nume){
                if(this.students[i].getGrade() >= this.minimumGrade)
                    return true;
                else return false;
            }
        }
        return false;
    }

    public boolean isStudentPassing(int index){
        if (index > this.students.length) return false;
        Student student = this.students[index];
        if (student.getGrade() >= this.minimumGrade)
            return true;
        return false;
    }
}
