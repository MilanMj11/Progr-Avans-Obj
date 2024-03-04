package lab1.task2;

public class StudentAllocator {

    public static Student[] createStudents(){
        Student student1 = new Student("Nume1", 5.5);
        Student student2 = new Student("Nume2", 6.7);
        Student student3 = new Student("Nume3", 9.7);
        Student student4 = new Student("Nume4", 10);
        Student[] lista = new Student[4];
        lista[0] = student1;
        lista[1] = student2;
        lista[2] = student3;
        lista[3] = student4;
        return lista;
    }
}
