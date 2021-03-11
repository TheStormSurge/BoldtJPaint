package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.interfaces.IShape;
import java.awt.*;

public class Rectangle extends AbstractShape implements IShape, Cloneable {

    public Rectangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        super(c,s,e,f,o,sh);
    }
    public void base(){
        Graphics2D graph=canvas.getGraphics2D();
        if (shade.equals("FILLED_IN")){
            graph.setColor(fill);
            graph.fillRect(x, y,width,height);
        }
        else if (shade.equals("OUTLINE")) {
            graph.setColor(fill);
            graph.setStroke(new BasicStroke(5));
            graph.drawRect(x, y,width,height);
        }
        else{ //FILLED IN w/ OUTLINE
            graph.setColor(fill);
            graph.fillRect(x, y,width,height);
            graph.setColor(outline);
            graph.setStroke(new BasicStroke(5));
            graph.drawRect(x, y,width,height);
        }
    }
}