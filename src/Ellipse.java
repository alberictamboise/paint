import java.awt.*;

public class Ellipse extends Figure {
    protected int height;
    protected int width;
    public Ellipse (int px, int py, Color c) {
        super(c, new Point(px, py));
    }
    @Override
    public void setBoundingBox(int heigthBB, int widthBB) {
        width = widthBB;
        height = heigthBB;
    }
    @Override
    public void setBoundingBox(Point x1, Point x2) {
        if (x1.getX() < x2.getX() & x2.getY() > x1.getY()) {
            width = (x2.getX() - x1.getX());
            height = (x2.getY() - x1.getY());
            super.x1.x =x1.getX();
            super.x1.y= x1.getY();
        }
        else if (x1.getX() > x2.getX() & x1.getY() < x2.getY()) {
            super.x1.x =x2.getX();
            super.x1.y= x1.getY();
            width = (x1.getX() - x2.getX());
            height = (x2.getY() - x1.getY());
        }
        else if (x2.getX() < x1.getX() & x2.getY() < x1.getY()) {
            super.x1.x =x2.getX();
            super.x1.y= x2.getY();
            width = (x1.getX() - x2.getX());
            height = ( x1.getY() - x2.getY());
        }else if (x1.getX() < x2.getX() & x2.getY() < x1.getY()) {
            super.x1.x =x1.getX();
            super.x1.y= x2.getY();
            width = (x2.getX() - x1.getX());
            height = (x1.getY() - x2.getY());
        }
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(x1.getX(), x1.getY(), width, height);
    }
}