package lab2.task6;

public class Romb extends Paralelogram {
    public double diagonala1, diagonala2;
    public Romb(int latura1,int latura2,int unghi1,int unghi2,int diagonala1, int diagonala2){
        super(latura1,latura2,unghi1,unghi2);
        this.diagonala1 = diagonala1;
        this.diagonala2 = diagonala2;
    }
    public double arie(){
        double rasp;
        rasp = (diagonala1 * diagonala2) / 2;
        return rasp;
    }
}
