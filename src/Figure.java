import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    private Color c;
    public Point p;
    public int remp;

    /*****Constructor*****/

    public Figure(java.awt.Color c, Point p, int r){
        this.c=c;
        this.p=p;
        this.remp=r;
    }

    /*****Getter*****/

    public Point getPoint(){return this.p;}
    public Color getColor(){return this.c;}

    /*****Setter*****/

    public abstract void setRemp(int r);
    public abstract void setBoundingBox(int heightBB, int widthBB);

    /*****Methode draw*****/

    public abstract void draw(Graphics g);

    /*****Override*****/

    @Override
    public String toString() {
        return "Figure{" +
                "c=" + c +
                ", p=" + p +
                '}';
    }
}
