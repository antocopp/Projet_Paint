import java.io.Serializable;

public class Point implements Serializable {

    private int X;
    private int Y;

    /*****Constructor*****/

    public Point(int a, int b){
        this.X=a;
        this.Y=b;
    }

    /*****Getter*****/

    public int getX() {return X;}
    public int getY() {return Y;}

    /*****Setter*****/

    public void setX(int x){this.X=x;}
    public void setY(int y){this.Y=y;}

    /*****Override*****/

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
