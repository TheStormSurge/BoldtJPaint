package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.ScreenShapes;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.gui.strategies.TraingleStrat;
import view.interfaces.IShape;
import java.awt.*;

public class Triangle extends AbstractShape implements IShape,Cloneable {
    int[] xs;
    int[] ys;

    public Triangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        super(c,s,e,f,o,sh);
        int[] calcx = {left.getX(),right.getX(),left.getX()};
        int[] calcy = {left.getY(),right.getY(), right.getY()};
        xs=calcx;
        ys=calcy;
        strategy=new TraingleStrat();
    }
    public int[] getXs(){
        return xs;
    }
    public int[] getYs(){
        return ys;
    }
    public void move(int offsetx, int offsety){
        x=x+offsetx;
        y=y+offsety;
        left= new MyPoint(new Point(x,y));
        right= new MyPoint(new Point(x+width,y+height));
        int[] calcx = {left.getX(),right.getX(),left.getX()};
        int[] calcy = {left.getY(),right.getY(), right.getY()};
        xs=calcx;
        ys=calcy;
        ScreenShapes.render();
    }
}
