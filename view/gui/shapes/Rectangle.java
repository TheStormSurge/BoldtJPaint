package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.gui.strategies.RectangleStrat;
import view.interfaces.IShape;
import java.awt.*;

public class Rectangle extends AbstractShape implements IShape, Cloneable {

    public Rectangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        super(c,s,e,f,o,sh);
        strategy=new RectangleStrat();
    }
}