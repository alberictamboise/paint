import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;
//firstpointabscisse  si blanc fait ça pour utlisier des noms sinon utiliser des 0 et des 1  le return permet d'éviter de mettre un else
//figure=NewElipse(liste.addfigure)
//mouse released ne sert pas , p

public class Drawing extends JPanel implements MouseListener, MouseMotionListener, Serializable {
    public Color c;
    public ArrayList<Figure> liste = new ArrayList<>();
    public int x;
    public int y;
    public String NewFigure;
    Figure figure;
    private Point x1;
    private Point x2;

    public Drawing() {
        this.x = 0;
        this.y = 0;
        this.setBackground(Color.white);
        liste.add(new Rectangle(0, 0, Color.BLACK));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);


    }

    public void setColor(Color c) {
        this.c = c;
    }

    public void setNewFigure(String NewFigure) {
        this.NewFigure = NewFigure;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = new Point(e.getX(), e.getY());
        //   if (NewFigure == "Ellipse") {

        //        System.out.println("Creation d'une" + NewFigure + "de couleur " + c + " et d'origine: " + x1.x + " " + x1.y);
        //   } else if (NewFigure != "Ellipse") {
        //       System.out.println("Creation d'un " + NewFigure + " de couleur " + c + " et d'origine: " + x1.x + " " + x1.y);
        //   }


        switch (NewFigure) {
            case "Ellipse":
                //liste.add(new Ellipse(x1, x2, c));
                figure = new Ellipse(x1.getX(), x1.getY(), c);
                liste.add(figure);
                break;

            case "Rectangle":
                figure = new Rectangle(x1.getX(), x1.getY(), c);
                liste.add(figure);

                break;
            case "Carre":
                // liste.add(new Square(x, y, c));
                figure = new Square(x1.getX(), x1.getY(), c);
                liste.add(figure);
                break;

            case "Circle":
                //liste.add(new Circle(x, y, c));
                figure = new Circle(x1.getX(), x1.getY(), c);
                liste.add(figure);
                break;

            //  }


        }
        System.out.println("Creation d'une" + NewFigure + "de couleur " + c + " et d'origine: " + x1.x + " " + x1.y);
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //on appuie sur un bouton
        x2 = new Point(e.getX(), e.getY());
        System.out.println("Creation d'un " + NewFigure + " de couleur " + c + " et de second point : " + x2.x + " " + x2.y);
        figure.setBoundingBox(x1, x2);
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
// pas de bouton enfoncé
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        for (Figure f : liste) {
            f.draw(g);
           //repaint appel paint componente this.repaint() il faut mettre les variables en privé et la largeur et la hauteur en protected ;
        }
    }
public void save(String fileName) {
    try {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(liste);
        out.close();
        System.out.println("\nSauvegardé avec succès...\n");
    } catch (Exception e) {
        System.out.println("Problèmos");
        e.printStackTrace();

    }
}
    public void read(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            liste = (ArrayList<Figure>) in.readObject();
            System.out.println("Ouvert avec succès");
            in.close();
            fileIn.close();
            repaint();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

