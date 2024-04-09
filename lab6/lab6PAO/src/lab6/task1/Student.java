package lab6.task1;

public class Student {

    private String nume;
    private double notaLab;
    private double notaPartial;
    private double notaExamen;

    public Student(String nume, double notaLab, double notaPartial, double notaExamen){
        this.nume = nume;
        this.notaLab = notaLab;
        this.notaPartial = notaPartial;
        this.notaExamen = notaExamen;
    }

    public double getNotaTotala(){
        return notaLab + notaPartial + notaExamen;
    }

    public double getNotaPartial(){
        return notaPartial;
    }

    public double getNotaMedie(){
        return getNotaTotala() / 3;
    }

    @Override
    public String toString() {
        return nume + " " + this.notaLab + " " + this.notaPartial + " " + this.notaExamen;
    }
}
