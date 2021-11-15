import java.awt.*;

public class Square extends Rectangle{

    public Square(Color c, Point p, int px, int remp) {
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
        this.setLength(cote);
        this.setWidth(cote);
    }

    @Override
    public void setLength(int x) {super.setLength(x);}

    @Override
    public void setWidth(int y) {super.setWidth(y);}

    @Override
    public void setRemp(int r) {super.setRemp(r);}
}