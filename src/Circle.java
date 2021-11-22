import java.awt.*;

public class Circle extends Ellipse {
    protected int height;
    protected int width;


    public Circle(int px, int py, Color c) {
        super(px, py, c);

    }
    @Override
    public void draw(Graphics g) {
            g.setColor(c);
            g.fillOval(x1.getX(), x1.getY(), width, width);

    }
    @Override
    public String toString() {
        return ("Creation d un cercle dee'origine" + x1 + " et de couleur" + c);
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