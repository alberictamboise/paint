import java.awt.*;

public class Square extends Rectangle {

    public Square(int px, int py, Color c) {
        super(px, py, c);
        setBoundingBox(0, 0);
    }

    @Override
    public void setBoundingBox(Point origin, Point endOfBox) {
        super.setBoundingBox(origin, endOfBox);
        if (width < height) {
            height = width;
            if (endOfBox.getX() < origin.getX() & endOfBox.getY() < origin.getY()) {
                super.x1.setY(origin.getY() - height);
            } else if (origin.getX() < endOfBox.getX() & endOfBox.getY() < origin.getY()) {
                super.x1.setY(origin.getY() - height);
            }
        } else {
            width = height;
            if (endOfBox.getX() < origin.getX() & endOfBox.getY() < origin.getY()) {
                super.x1.setX(origin.getX() - width);
            } else if (endOfBox.getX() < origin.getX() & origin.getY() < endOfBox.getY()) {
                super.x1.setX(origin.getX() - width);
            }
        }
    }
}