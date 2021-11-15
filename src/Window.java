import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame implements ActionListener{


        public Window(String Title, int x, int y) {
                super(Title);
                this.setSize(x, y);
                this.setVisible(true);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Container contentPanel = this.getContentPane();

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

                JPanel s = new JPanel();
                s.setLayout(new GridLayout(1,2));
                JPanel c = new JPanel();
                c.setLayout(new GridLayout(2,5));
                JPanel f = new JPanel();
                f.setLayout(new GridLayout(2,3));

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
                JButton crayon = new JButton("Crayon");
                crayon.setBackground(Color.LIGHT_GRAY);
                crayon.addActionListener(this);
                JButton fill = new JButton("Remplir");
                fill.setBackground(Color.LIGHT_GRAY);
                fill.addActionListener(this);

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
                f.add(crayon);
                f.add(rectangle);
                f.add(carre);
                f.add(fill);
                f.add(ellispe);
                f.add(cercle);
                contentPanel.add(s,BorderLayout.SOUTH);

        }

        public void actionPerformed(ActionEvent e)
        {
                String cmd=e.getActionCommand();
                switch (cmd)
                {
                        case "Noir" :
                                Drawing.setC(Color.BLACK);
                                break;
                        case "Gris" :
                                Drawing.setC(Color.GRAY);
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
                                Drawing.setLastNF(Drawing.getNameFigure());
                                Drawing.setNameFigure("Remplir");
                                break;
                        case "New" :

                                break;
                        case "Open" :

                                break;
                        case "Save" :

                                break;
                        case "Quit" :
                                this.dispose();
                                break;
                }
        }

        public static void main (String[] args){

                Window win = new Window("Paint",1000,600);
                Drawing dr = new Drawing();
                win.add(dr);
                win.setVisible(true);

        }
}