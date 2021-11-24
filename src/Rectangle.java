import java.awt.*;

public class Rectangle extends Figure {
    private int length;
    private int width;

    /*****Constructor*****/

    public Rectangle(Color c, Point p, int px, int py, int remp){
        super(c, p, remp);
        this.length=px;
        this.width=py;
    }

    /*****Getter*****/

    public int getLength(){return length;}
    public int getWidth(){return width;}

    /*****Setter*****/

    public void setLength(int x){this.length=x;}
    public void setWidth(int y){this.width=y;}
    public void setRemp(int r){this.remp=r;}

    /* dans le setBB on modifie le point de tracer de la figure si les longueurs sont négatives */
    /* ce n'est surement aps la méthode la plus efficace mais ça fonctionne */
    public void setBoundingBox(int heightBB, int widthBB){
        if (widthBB<0){
            this.getPoint().setX(Drawing.getListP().get(Drawing.getListP().size()-1).getX()+widthBB);
        }
        if (heightBB<0){
            this.getPoint().setY(Drawing.getListP().get(Drawing.getListP().size()-1).getY()+heightBB);
        }
        this.setLength(Math.abs(widthBB));
        this.setWidth(Math.abs(heightBB));
    }

    /*****Methode draw*****/

    public void draw(Graphics g) {
        g.setColor(getColor());
        if (remp==1) {
            g.fillRect(getPoint().getX(), getPoint().getY(), getLength(), getWidth());
        }
        else {
            g.drawRect(getPoint().getX(), getPoint().getY(), getLength(), getWidth());
        }
    }

    /*****Override*****/

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
