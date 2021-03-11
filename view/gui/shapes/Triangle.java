package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.ScreenShapes;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
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
    }
    public void base(){
        Graphics2D graph = canvas.getGraphics2D();
        if (shade.equals("FILLED_IN")){
            graph.setColor(fill);
            graph.fillPolygon(xs,ys,3);
        }
        else if (shade.equals("OUTLINE")) {
            graph.setColor(fill);
            graph.setStroke(new BasicStroke(5));
            graph.drawPolygon(xs,ys,3);
        }
        else{ //FILLED IN w/ OUTLINE
            graph.setColor(fill);
            graph.fillPolygon(xs,ys,3);
            graph.setColor(outline);
            graph.setStroke(new BasicStroke(5));
            graph.drawPolygon(xs, ys,3);
        }
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
