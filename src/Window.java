import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{

        /*****Constructor*****/
        /* On créé la fenêtre et on y place toute l'interface visuel (bouttons, menu etc) */

        public Window(String Title, int x, int y) {
                super(Title);
                this.setSize(x, y);
                this.setVisible(true);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container contentPanel = this.getContentPane();

                /*****Menu file*****/

                JMenuBar m = new JMenuBar();
                JMenu menu1 = new JMenu("File");
                JMenuItem open = new JMenuItem("Open");
                open.addActionListener(this);
                JMenuItem n = new JMenuItem("New");
                n.addActionListener(this);
                JMenuItem save = new JMenuItem("Save");
                save.addActionListener(this);
                JMenuItem quit = new JMenuItem("Quit");
                quit.addActionListener(this);
                menu1.add(n);
                menu1.add(open);
                menu1.add(save);
                menu1.add(quit);
                m.add(menu1);
                contentPanel.add(m, BorderLayout.NORTH);

                /*****Tableau des boutons*****/

                JPanel s = new JPanel();
                s.setLayout(new GridLayout(1,2));
                JPanel c = new JPanel();
                c.setLayout(new GridLayout(2,5));
                JPanel f = new JPanel();
                f.setLayout(new GridLayout(2,3));
                JPanel cr=new JPanel();
                cr.setLayout(new GridLayout(1,2));

                /*****Boutons*****/

                JButton noir = new JButton("Noir");
                noir.setBackground(Color.BLACK);
                noir.setForeground(Color.WHITE);
                noir.addActionListener(this);
                JButton rouge = new JButton("Rouge");
                rouge.setBackground(Color.RED);
                rouge.addActionListener(this);
                JButton jaune = new JButton("Jaune");
                jaune.setBackground(Color.YELLOW);
                jaune.addActionListener(this);
                JButton bleu = new JButton("Bleu");
                bleu.setBackground(Color.BLUE);
                bleu.setForeground(Color.WHITE);
                bleu.addActionListener(this);
                JButton vert = new JButton("Vert");
                vert.setBackground(Color.GREEN);
                vert.addActionListener(this);
                JButton orange = new JButton("Orange");
                orange.setBackground(Color.ORANGE);
                orange.addActionListener(this);
                JButton rose = new JButton("Rose");
                rose.setBackground(Color.PINK);
                rose.addActionListener(this);
                JButton magenta = new JButton("Magenta");
                magenta.setBackground(Color.MAGENTA);
                magenta.addActionListener(this);
                JButton cyan = new JButton("Cyan");
                cyan.setBackground(Color.CYAN);
                cyan.addActionListener(this);
                JButton gris = new JButton("Gris");
                gris.setBackground(Color.GRAY);
                gris.setForeground(Color.WHITE);
                gris.addActionListener(this);
                JButton rectangle = new JButton("Rectangle");
                rectangle.setBackground(Color.WHITE);
                rectangle.addActionListener(this);
                JButton cercle = new JButton("Cercle");
                cercle.setBackground(Color.WHITE);
                cercle.addActionListener(this);
                JButton ellispe = new JButton("Ellipse");
                ellispe.setBackground(Color.WHITE);
                ellispe.addActionListener(this);
                JButton carre = new JButton("Carré");
                carre.setBackground(Color.WHITE);
                carre.addActionListener(this);
                JButton petit = new JButton("Fin");
                petit.setBackground(Color.LIGHT_GRAY);
                petit.addActionListener(this);
                JButton grand = new JButton("Large");
                grand.setBackground(Color.LIGHT_GRAY);
                grand.addActionListener(this);
                JButton fill = new JButton("Remplir");
                fill.setBackground(Color.LIGHT_GRAY);
                fill.addActionListener(this);

                /*****Ajout des boutons au tableau*****/

                s.add(c);
                s.add(f);
                c.add(noir);
                c.add(gris);
                c.add(bleu);
                c.add(cyan);
                c.add(vert);
                c.add(jaune);
                c.add(orange);
                c.add(rose);
                c.add(magenta);
                c.add(rouge);
                f.add(cr);
                cr.add(petit);
                cr.add(grand);
                f.add(rectangle);
                f.add(carre);
                f.add(fill);
                f.add(ellispe);
                f.add(cercle);
                contentPanel.add(s,BorderLayout.SOUTH);

        }

        /*****Méthode pour savoir sur quel bouton on clique*****/

        public void actionPerformed(ActionEvent e)
        {
                String cmd=e.getActionCommand();
                switch (cmd)
                {
                        case "Noir" :
                                Drawing.setC(Color.BLACK);
                                break;
                        case "Gris" :
                                Drawing.setC(Color.LIGHT_GRAY);
                                break;
                        case "Rouge" :
                                Drawing.setC(Color.RED);
                                break;
                        case "Bleu" :
                                Drawing.setC(Color.BLUE);
                                break;
                        case "Jaune" :
                                Drawing.setC(Color.YELLOW);
                                break;
                        case "Cyan" :
                                Drawing.setC(Color.CYAN);
                                break;
                        case "Orange" :
                                Drawing.setC(Color.ORANGE);
                                break;
                        case "Rose" :
                                Drawing.setC(Color.PINK);
                                break;
                        case "Magenta" :
                                Drawing.setC(Color.MAGENTA);
                                break;
                        case "Vert" :
                                Drawing.setC(Color.GREEN);
                                break;
                        case "Cercle" :
                                Drawing.setNameFigure("Cercle");
                                break;
                        case "Rectangle" :
                                Drawing.setNameFigure("Rectangle");
                                break;
                        case "Carré" :
                                Drawing.setNameFigure("Carré");
                                break;
                        case "Ellipse" :
                                Drawing.setNameFigure("Ellipse");
                                break;
                        case "Remplir" :
                                /* On fait une sauvegarde de la figure d'avant pour retracer une figure après la fonction remplir*/
                                Drawing.setLastNF(Drawing.getNameFigure());
                                Drawing.setNameFigure("Remplir");
                                break;
                        case "Fin" :
                                Drawing.setNameFigure("Petit");
                                break;
                        case "Large" :
                                Drawing.setNameFigure("Grand");
                                break;
                        case "New" :
                                Drawing.getListF().clear();
                                break;
                        case "Open" :
                                Drawing.setLastNF(Drawing.getNameFigure());
                                Drawing.setNameFigure("Open");
                                break;
                        case "Save" :
                                Drawing.setLastNF(Drawing.getNameFigure());
                                Drawing.setNameFigure("Save");
                                break;
                        case "Quit" :
                                this.dispose();
                                break;

                }
        }

        /*****Main*****/

        public static void main (String[] args){
                Window win = new Window("Paint",1000,600);
                Drawing dr = new Drawing();
                win.add(dr);
                win.setVisible(true);
        }
}