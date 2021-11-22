import java.awt.*;

public class Ellipse extends Figure {
    protected int height;
    protected int width;



    public Ellipse (int px, int py, Color c) {
        super(c, new Point(px, py));
        setBoundingBox(0, 0);
    }


    //problemes d'encapsulation et d'injection de dépandance
    @Override
    public void setBoundingBox(int heigthBB, int widthBB) {
        width = widthBB;
        height = heigthBB;

    }

    @Override
    public void setBoundingBox(Point x1, Point x2) {


        if (x1.getX() < x2.getX() & x2.getY() > x1.getY()) { // tire en bas à droite
            Point originBis = new Point(x1.getX(), x1.getY());
            Point secondBis = new Point(x2.getX(), x2.getY());
            width = (secondBis.getX() - originBis.getX());
            height = (secondBis.getY() - originBis.getY());
        } else if (x2.getX() < x1.getX() & x2.getY() < x1.getY()) { // tire en haut à gauche
            Point originBis = new Point(x2.getX(), x2.getY());
            Point secondBis = new Point(x1.getX(), x1.getY());
            super.x1 = originBis;
            width = (secondBis.getX() - originBis.getX());
            height = (secondBis.getY() - originBis.getY());



        }else if (x1.getX() < x2.getX() & x2.getY() < x1.getY()) { // tire en haut à gauche
            Point originBis = new Point(x1.getX(), x2.getY());
            Point secondBis = new Point(x2.getX(), x1.getY());
            super.x1 = originBis;
            width = (secondBis.getX() - originBis.getX());
            height = (secondBis.getY() - originBis.getY());
        }
        else if (x1.getX() > x2.getX() & x1.getY() < x2.getY()) { // tire en bas à gauche
            Point originBis = new Point(x2.getX(), x1.getY());
            Point secondBis = new Point(x1.getX(), x2.getY());
            super.x1 = originBis;
            width = (secondBis.getX() - originBis.getX());
            height = (secondBis.getY() - originBis.getY());
        }


    }

    @Override
    public void draw(Graphics g) {


        g.setColor(c);
        g.fillOval(x1.getX(), x1.getY(), width, height);

    }

    @Override
    public String toString() {
        return ("Creation d un cercle d'origine" + x1 + " et de couleur" + c);
    }


    @Override
    public Color getC() {
        return super.getC();
    }

    @Override
    public void setC(Color c) {
        super.setC(c);

    }


}