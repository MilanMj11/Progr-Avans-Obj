package lab2.task6;

import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class Paralelogram extends Patrulater{
    public Paralelogram(int latura1,int latura2,int unghi1,int unghi2){
        super(latura1,latura2,latura1,latura2,unghi1,unghi2,unghi1,unghi2);
    }
    public double arie(){
        double rasp;
        rasp = latura1 * latura2 * sin(toRadians(unghi1));
        return rasp;
    }
}
