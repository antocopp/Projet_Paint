import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.*;


public class Drawing extends JPanel implements MouseListener,MouseMotionListener {

    private static Color color;
    private static String nameFigure;
    private static String lastNF;
    private static ArrayList<Figure> listF;
    private static ArrayList<Point> listP;

    /*****Constructor*****/

    public Drawing() {
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setBackground(Color.white);
        this.listF=new ArrayList<>();
        this.listP=new ArrayList<>();
    }

    /*****Getter*****/

    public static String getNameFigure(){return nameFigure;}
    public static ArrayList<Figure> getListF() {
        return listF;
    }
    public static ArrayList<Point> getListP() {
        return listP;
    }

    /*****Setter*****/

    public static void setC(Color c) {
        color = c;
    }
    public static void setNameFigure(String nF) {nameFigure = nF;}
    public static void setLastNF(String lNF){lastNF=lNF;}

    /*****Methode save et recall*****/
    /* Ces fonctions ne fonctionnent pas */

    public void save(){
        try{
            FileOutputStream fos = new FileOutputStream("sauveDessin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(listF.size());
            for(Figure f : listF) {
                oos.writeObject(f);
            }
            oos.close();
        }
        catch (Exception e){
            System.out.println("Erreur");
        }
    }

    public void recall(){
        listF.clear();
        listP.clear();
        try{
            FileInputStream fis = new FileInputStream("saveDessin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ois.close();
        }
        catch (Exception e){
            System.out.println("Erreur");
        }
    }

    /*****Override*****/

    /* paintComponent permet de dessiner les figures de la liste */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (nameFigure=="Remplir"){
            listF.get(listF.size()-1).setRemp(1);
            setNameFigure(lastNF);
        }
        if (nameFigure=="Save"){
            save();
            setNameFigure(lastNF);
        }
        if (nameFigure=="Open"){
            recall();
            setNameFigure(lastNF);
        }
        for (int i = 0; i < listF.size(); i++) {
            listF.get(i).draw(g);
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    /* mousepressed permet de creer une nouvelle figure a chaque fois qu'on clique sur le drawing */
    @Override
    public void mousePressed(MouseEvent e) {
        Point pt1 = new Point(e.getX(),e.getY());
        Point pt0 = new Point(e.getX(),e.getY());
        listP.add(pt0);
        String fig = nameFigure;
        switch (fig){
            case "Cercle":
                Circle cer = new Circle(color, pt1,0,0);
                listF.add(cer);
                break;
            case "Rectangle":
                Rectangle rec = new Rectangle(color, pt1, 0,0,0);
                listF.add(rec);
                break;
            case "Ellipse" :
                Ellipse ell = new Ellipse(color, pt1, 0,0,0);
                listF.add(ell);
                break;
            case "Carré":
                Square squ = new Square(color, pt1,0,0);
                listF.add(squ);
                break;
            case "Petit":
                Pen pen = new Pen(color,pt1,0);
                listF.add(pen);
                break;
            case "Grand":
                Pen gpen = new Pen(color,pt1,0);
                listF.add(gpen);
                break;
            }
    }

    /* mousedragged permet de tracer la figure en temps réel tant que le clic est enfoncé */
    @Override
    public void mouseDragged(MouseEvent e) {
        Point pt = new Point(e.getX(),e.getY());
        if (nameFigure=="Petit"){
            Pen pen = new Pen(color,pt,0);
            listF.add(pen);
        }
        if (nameFigure=="Grand"){
            Pen pen = new Pen(color,pt,1);
            listF.add(pen);
        }
        int w = pt.getX()-listP.get(listP.size()-1).getX();
        int h = pt.getY()-listP.get(listP.size()-1).getY();
        listF.get(listF.size()-1).setBoundingBox(h,w);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}

}
