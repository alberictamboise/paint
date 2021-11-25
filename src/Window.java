import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//list avec les figures et couleurs et on boucle dessus
// switch case est une occasion rate d'utilisé l'heritage en une ligne bouton action action est une methode ajouter au bouton drawpanel est dans le constructeur du bouton
public class Window extends JFrame implements ActionListener {
    Drawing draw = new Drawing();

    public Window(String Title, int x, int y) {
        super(Title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane();

        JMenuBar m = new JMenuBar();


        JMenu menu1 = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        menu1.add(open);
        open.addActionListener(this);
        JMenuItem neww = new JMenuItem("New");
        menu1.add(neww);
        JMenuItem save = new JMenuItem("Save");
        menu1.add(save);
        save.addActionListener(this);

        JMenuItem quit = new JMenuItem("Quit");
        menu1.add(quit);
        m.add(menu1);


        JMenu menu2 = new JMenu("A Propos");
        m.add(menu2);
        this.setJMenuBar(m);


        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 6));

        JButton Noir = new JButton("Noir");
        Noir.setBackground(Color.BLACK);
        southPanel.add(Noir);
        Noir.addActionListener(this);
        Noir.setForeground(Color.white);


        JButton Rouge = new JButton("Rouge");
        Rouge.setBackground(Color.RED);
        southPanel.add(Rouge);
        Rouge.addActionListener(this);

        JButton Vert = new JButton("Vert");
        Vert.setBackground(Color.green);
        southPanel.add(Vert);
        Vert.addActionListener(this);

        JButton Bleu = new JButton("Bleu");
        Bleu.setBackground(Color.BLUE);
        southPanel.add(Bleu);
        Bleu.addActionListener(this);
        Bleu.setForeground(Color.white);

        JButton Ellipse = new JButton("Ellipse");
        southPanel.add(Ellipse);
        Ellipse.addActionListener(this);
        Ellipse.addActionListener(this);

        JButton Circle = new JButton("Circle");
        southPanel.add(Circle);
        Circle.addActionListener(this);

        JButton Yellow = new JButton("Jaune");
        southPanel.add(Yellow);
        Yellow.setBackground(Color.YELLOW);
        Yellow.addActionListener(this);


        JButton Pink = new JButton("Rose");
        southPanel.add(Pink);
        Pink.setBackground(Color.PINK);
        Pink.addActionListener(this);

        JButton Magenta = new JButton("Magenta");
        Magenta.setBackground(Color.MAGENTA);
        southPanel.add(Magenta);
        Magenta.addActionListener(this);

        JButton Orange = new JButton("Orange");
        Orange.setBackground(Color.ORANGE);
        southPanel.add(Orange);
        Orange.addActionListener(this);

        JButton Rectangle = new JButton("Rectangle");
        southPanel.add(Rectangle);
        Rectangle.addActionListener(this);

        JButton Carre = new JButton("Carre");
        southPanel.add(Carre);
        Carre.addActionListener(this);

        //JOptionPane info = new JOptionPane();
        //JOptionPane.showInternalMessageDialog(info, "Bienvenue sur le paint de Albéric",
              //  "information", JOptionPane.INFORMATION_MESSAGE);

        contentPanel.add(southPanel, "South");
        contentPanel.add(draw);

        southPanel.setVisible(true);
        southPanel.setVisible(true);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Window("Paint", 1000, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {


            case "Rouge":
                System.out.println("la couleur  rouge est choisie");
                draw.setColor(Color.RED);
                break;
            case "Noir":
                System.out.println("Le couleur  noir est choisi");
                draw.setColor(Color.black);
                break;
            case "Vert":
                System.out.println("Vert");
                draw.setColor(Color.green);
                break;
            case "Bleu":
                System.out.println("la couleur bleu est choisie");
                draw.setColor(Color.blue);
                break;
            case "Ellipse":
                System.out.println("création d'une éllipse");
                draw.setNewFigure("Ellipse");

                break;
            case "Jaune":
                System.out.println("La couleur jaune est choisi");
                draw.setColor(Color.yellow);
                break;
            case "Rose":
                System.out.println("La couleur rose est choisi");
                draw.setColor(Color.pink);
                break;
            case "Magenta":
                System.out.println("La couleur magenta est choisi");
                draw.setColor(Color.magenta);
                break;
            case "Orange":
                System.out.println("La couleur orange est choisi");
                draw.setColor(Color.orange);
                break;

            case "Rectangle":
                System.out.println("création d'un rectangle");
                draw.setNewFigure("Rectangle");
                break;
            case "Carre":
                System.out.println("création d'un carré");
                draw.setNewFigure("Carre");
                break;
            case "Circle":
                System.out.println("création d'un cercle");
                draw.setNewFigure("Circle");
                break;
            case "Save":
                JFileChooser choosersave = new JFileChooser();
                int selected = choosersave.showSaveDialog(this);
                if(selected==JFileChooser.APPROVE_OPTION){
                    String fileToSave = choosersave.getSelectedFile().getAbsolutePath();
                    draw.save(fileToSave);
                    System.out.println("saved file");
                } else{
                    System.out.println("failed to saved file");;
                }
                break;
                case "Open":
                JFileChooser chooseropen = new JFileChooser();
                 int selected2 = chooseropen.showOpenDialog(this);
                 if(selected2==JFileChooser.APPROVE_OPTION){
                 String fileToOpen = chooseropen.getSelectedFile().getAbsolutePath();
                 draw.read(fileToOpen);
            System.out.println("file open");
        } else{
            System.out.println("file not open ");;
        }


    }
        }
    }
