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
        if (remp==0){
            g.fillOval(p.getX()-1,p.getY()-1,3,3);}
        if (remp==1){
            g.fillOval(p.getX()-3,p.getY()-3,7,7);}
    }
}
