import java.awt.*;

public class Circle extends Ellipse {

    public Circle(Color c, Point p, int px, int remp) {
        super(c, p, px, px, remp);
    }

    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        int cote = Math.min(Math.abs(heightBB),Math.abs(widthBB));
        if (widthBB<0){
            this.getPoint().setX(this.getPoint().getX()-cote);
        }
        if (heightBB<0){
            this.getPoint().setY(this.getPoint().getY()-cote);
        }
        this.setSemiAxysX(cote);
        this.setSemiAxysY(cote);
    }

    @Override
    public void setSemiAxysX(int x) {super.setSemiAxysX(x);}

    @Override
    public void setSemiAxysY(int y) {super.setSemiAxysY(y);}

    @Override
    public void setRemp(int r) {super.setRemp(r);}
}
