import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {

    public Color c;
    protected Point x1;


    public Figure(Color c, Point p) {
        this.c = c;
        this.x1 = p;
    }

    public Figure() {
        c = new Color(255, 255, 255);
        x1 = new Point(0, 0);
    }

    public static void main(String[] args) {
    }

    public abstract void setBoundingBox(Point x1, Point x2);

    public abstract void setBoundingBox(int heightBB, int widthBB);

    public abstract void draw(Graphics g);

    //getter couleur
    public Color getC() {
        return c;
    }

    //setter couleur
    public void setC(Color c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Figure{}";
    }

    public Point getX1() {
        return x1;
    }

    public void setX1(Point x1) {
        this.x1 = x1;
    }

}