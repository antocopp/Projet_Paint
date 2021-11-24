import java.awt.*;

public class Ellipse extends Figure {
    private int semiAxysX;
    private int semiAxysY;

    /*****Constructor*****/

    public Ellipse(Color c, Point p, int px, int py, int remp) {
        super(c, p, remp);
        this.semiAxysX = px;
        this.semiAxysY=py;
    }

    /*****Getter*****/

    public int getSemiAxysX() {return semiAxysX;}
    public int getSemiAxysY() {
        return semiAxysY;
    }

    /*****Setter*****/

    public void setSemiAxysX(int x){this.semiAxysX=x;}
    public void setSemiAxysY(int y){this.semiAxysY=y;}
    public void setRemp(int r){this.remp=r;}

    /* dans le setBB on modifie le point de tracer de la figure si les longueurs sont négatives */
    /* ce n'est surement aps la méthode la plus efficace mais ça fonctionne */
    public void setBoundingBox(int heightBB, int widthBB) {
        if (widthBB<0){
            this.getPoint().setX(Drawing.getListP().get(Drawing.getListP().size()-1).getX()+widthBB);
        }
        if (heightBB<0){
            this.getPoint().setY(Drawing.getListP().get(Drawing.getListP().size()-1).getY()+heightBB);
        }
        this.setSemiAxysX(Math.abs(widthBB));
        this.setSemiAxysY(Math.abs(heightBB));
    }

    /*****Methode draw*****/

    public void draw(Graphics g){
        g.setColor(getColor());
        if (remp==1) {
            g.fillOval(getPoint().getX(), getPoint().getY(), getSemiAxysX(), getSemiAxysY());
        }
        else {
            g.drawOval(getPoint().getX(),getPoint().getY(),getSemiAxysX(),getSemiAxysY());
        }
    }

    /*****Override*****/

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiAxysX=" + semiAxysX +
                ", semiAxysY=" + semiAxysY +
                '}';
    }
}
