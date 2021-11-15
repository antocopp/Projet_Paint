import java.awt.*;

public class Pen extends Figure{
    public Pen(Color c, Point p, int remp){
        super(c, p,remp);

    }


    public void setRemp(int r) {}
    public int getPerimeter(){return 1;}
    public int getSurface(){return 1;}
    public void setBoundingBox(int heightBB, int widthBB){}

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(p.getX(),p.getY(),p.getX(),p.getY());
    }
}
