package lab2.task6;

public class Dreptunghi extends Paralelogram{
    public Dreptunghi(int latura1,int latura2){
        super(latura1,latura2,90,90);
    }
    public double arie(){
        double rasp;
        rasp = latura1 * latura2;
        return rasp;
    }
}
