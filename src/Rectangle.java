



import java.awt.*;

public class Rectangle extends Figure {
    protected int height;
    protected int width;



    public Rectangle(int px, int py, Color c) {
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

        Point fin = new Point();

        if (x1.getX() < x2.getX() & x2.getY() > x1.getY()) {
            Point newOrigin = new Point(x1.getX(), x1.getY());
            Point endOfLine = new Point(x2.getX(), x2.getY());
            height = (endOfLine.getY() - newOrigin.getY());
            width = (endOfLine.getX() - newOrigin.getX());
        }
             else if (x1.getX() > x2.getX() & x1.getY() < x2.getY()) {
                Point newOrigin = new Point(x2.getX(), x1.getY());
                Point endOfLine = new Point(x1.getX(), x2.getY());
                super.x1 = newOrigin;
                height = (endOfLine.getY() - newOrigin.getY());
                width = (endOfLine.getX() - newOrigin.getX());
            }
         else if (x2.getX() < x1.getX() & x2.getY() < x1.getY()) {
            Point newOrigin = new Point(x2.getX(), x2.getY());
            Point endOfLine = new Point(x1.getX(), x1.getY());
            super.x1 = newOrigin;
            height = (endOfLine.getY() - newOrigin.getY());
            width = (endOfLine.getX() - newOrigin.getX());
        }else if (x1.getX() < x2.getX() & x2.getY() < x1.getY()) {
            Point newOrigin = new Point(x1.getX(), x2.getY());
            Point endOfLine = new Point(x2.getX(), x1.getY());
            super.x1 = newOrigin;
            height = (endOfLine.getY() - newOrigin.getY());
            width = (endOfLine.getX() - newOrigin.getX());
        }

    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillRect(x1.getX(), x1.getY(), width, height);
    }
}