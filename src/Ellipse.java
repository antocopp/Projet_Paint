import java.awt.*;

public class Ellipse extends Figure {
    private int semiAxysX;
    private int semiAxysY;

    public Ellipse(Color c, Point p, int px, int py, int remp) {
        super(c, p, remp);
        this.semiAxysX = px;
        this.semiAxysY=py;
    }

    public int getSemiAxysX() {return semiAxysX;}
    public int getSemiAxysY() {
        return semiAxysY;
    }

    public void setSemiAxysX(int x){this.semiAxysX=x;}
    public void setSemiAxysY(int y){this.semiAxysY=y;}
    public void setRemp(int r){this.remp=r;}

    public int getPerimeter(){return 1;}
    public int getSurface(){return 1;}
    public void setBoundingBox(int heightBB, int widthBB) {
        if (widthBB<0){
            this.getPoint().setX(this.getPoint().getX()+widthBB);
        }
        if (heightBB<0){
            this.getPoint().setY(this.getPoint().getY()+heightBB);
        }
        this.setSemiAxysX(Math.abs(widthBB));
        this.setSemiAxysY(Math.abs(heightBB));
    }

    public void draw(Graphics g){
        g.setColor(getColor());
        if (remp==1) {
            g.fillOval(getPoint().getX(), getPoint().getY(), getSemiAxysX(), getSemiAxysY());
        }
        else {
            g.drawOval(getPoint().getX(),getPoint().getY(),getSemiAxysX(),getSemiAxysY());
        }
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxysX=" + semiAxysX +
                ", semiAxysY=" + semiAxysY +
                '}';
    }
}
