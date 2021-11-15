import java.awt.*;

public class Rectangle extends Figure {
    private int length;
    private int width;

    public Rectangle(Color c, Point p, int px, int py, int remp){
        super(c, p, remp);
        this.length=px;
        this.width=py;
    }

    public int getLength(){return length;}
    public int getWidth(){return width;}

    public void setLength(int x){this.length=x;}
    public void setWidth(int y){this.width=y;}
    public void setRemp(int r){this.remp=r;}

    public int getPerimeter(){return (length+width)*2;}
    public int getSurface(){return length*width;}
    public void setBoundingBox(int heightBB, int widthBB){
        this.setLength(Math.abs(widthBB));
        this.setWidth(Math.abs(heightBB));
        if (widthBB<0){
            this.getPoint().setX(this.getPoint().getX()+widthBB);
        }
        if (heightBB<0){
            this.getPoint().setY(this.getPoint().getY()+heightBB);
        }
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        if (remp==1) {
            g.fillRect(getPoint().getX(), getPoint().getY(), getLength(), getWidth());
        }
        else {
            g.drawRect(getPoint().getX(), getPoint().getY(), getLength(), getWidth());
        }
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
