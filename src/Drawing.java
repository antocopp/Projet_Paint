import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.*;


public class Drawing extends JPanel implements MouseListener,MouseMotionListener{

    private static Color color;
    private static String nameFigure;
    private static String lastNF;
    private ArrayList<Figure> listF;

    public static void setC(Color c) {
        color = c;
    }
    public static void setNameFigure(String nF) {nameFigure = nF;}
    public static void setLastNF(String lNF){lastNF=lNF;}
    public static String getNameFigure(){return nameFigure;}

    public Drawing() {
        addMouseListener(this);
        addMouseMotionListener(this);
        this.setBackground(Color.white);
        this.listF=new ArrayList<>();
    }

    public ArrayList<Figure> getListF() {
        return listF;
    }

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (nameFigure=="Remplir"){
            listF.get(listF.size()-1).setRemp(1);
            setNameFigure(lastNF);
        }
        for (int i = 0; i < listF.size(); i++) {
            listF.get(i).draw(g);
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        Point pt1 = new Point(e.getX(),e.getY());
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
            case "Crayon":

                break;
            }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        Point pt = new Point(e.getX(),e.getY());
        int w = pt.getX()-listF.get(listF.size()-1).getPoint().getX();
        int h = pt.getY()-listF.get(listF.size()-1).getPoint().getY();
        listF.get(listF.size()-1).setBoundingBox(h,w);
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

}
