package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.gui.strategies.OvalStrat;
import view.interfaces.IShape;
import java.awt.*;

public class Ellipse extends AbstractShape implements IShape, Cloneable {

    public Ellipse(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        super(c,s,e,f,o,sh);
        strategy= new OvalStrat();
    }
}