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
    private Color c;
    private ArrayList<Figure> liste = new ArrayList<>();
    private int x;
    private int y;
    private String NewFigure;
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
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
        x1 = new Point(e.getX(), e.getY());
        switch (NewFigure) {
            case "Ellipse":
                System.out.println("you are creating a ");
                figure = new Ellipse(x1.getX(), x1.getY(), c);
                liste.add(figure);
                break;
            case "Rectangle":
                System.out.println("you are creating a ");
                figure = new Rectangle(x1.getX(), x1.getY(), c);
                liste.add(figure);
                break;
            case "Carre":
                figure = new Square(x1.getX(), x1.getY(), c);
                liste.add(figure);
                break;

            case "Circle":
                figure = new Circle(x1.getX(), x1.getY(), c);
                liste.add(figure);
                System.out.println("you are creating a " + NewFigure + " of color " + c + " qdsfgh,uyi;uoiytrhegf: " + x1.x + " " + x1.y);
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
        x2 = new Point(e.getX(), e.getY());
        System.out.println("you are creating a" + NewFigure + " of color " + c + " and second point  eeeee" + x2.x + " " + x2.y);
        figure.setBoundingBox(x1, x2);
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        for (Figure f : liste) {
            f.draw(g);
        }
    }
public void save(String fileName) {
    try {
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(liste);
        out.close();
        System.out.println("\nSuccessfully saved\n");
    } catch (Exception e) {
        System.out.println("failed to save successfully");
        e.printStackTrace();

    }
}
    public void read(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            liste = (ArrayList<Figure>) in.readObject();
            System.out.println("Successfully open");
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

