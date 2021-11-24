import java.awt.*;

public class Circle extends Ellipse {

    /*****Constructor*****/

    public Circle(Color c, Point p, int px, int remp) {
        super(c, p, px, px, remp);
    }

    /*****Override*****/
    /* la classe Square étant étendu de rectangle, elle ne contient que des override */

    /* dans le setBB on modifie le point de tracer de la figure si les longueurs sont négatives */
    /* ce n'est surement aps la méthode la plus efficace mais ça fonctionne */
    @Override
    public void setBoundingBox(int heightBB, int widthBB) {
        int cote = Math.min(Math.abs(heightBB),Math.abs(widthBB));
        if (widthBB<0){
            this.getPoint().setX(Drawing.getListP().get(Drawing.getListP().size()-1).getX()-cote);
        }
        if (heightBB<0){
            this.getPoint().setY(Drawing.getListP().get(Drawing.getListP().size()-1).getY()-cote);
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
