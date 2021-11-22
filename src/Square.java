import java.awt.*;

public class Square extends Rectangle {

    public Square(int px, int py, Color c) {
        super(px,py,c);
        setBoundingBox(0, 0);
    }

    @Override
    public void draw(Graphics g) {
        if(height>width){
            g.setColor(c);
            g.fillRect(x1.getX(), x1.getY(), width, width);
        }else{
            g.setColor(c);
            g.fillRect(x1.getX(), x1.getY(), height,height );
        }


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