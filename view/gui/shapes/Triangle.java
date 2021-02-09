package view.gui.shapes;

import model.ShapeShadingType;
import view.gui.ScreenShapes;
import view.gui.shape_command.DrawShape;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.interfaces.IShape;

import java.awt.*;

public class Triangle implements IShape {
    public MyPoint start;
    public MyPoint end;
    PaintCanvas canvas;
    Color fill;
    Color outline;
    String shade;
    int[] xs;
    int[] ys;

    public Triangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        start=s;
        end=e;
        canvas=c;
        fill=f;
        outline=o;
        int[] calcx = {s.getX(),e.getX(),s.getX()};
        int[] calcy = {s.getY(),e.getY(), e.getY()};
        xs=calcx;
        ys=calcy;
        canvas=c;
        fill=f;
        outline=o;
        shade=sh.toString();
    }
    public void draw(){
        ScreenShapes.add(this);
        new DrawShape(this).run();
    }
    public MyPoint getStart() {
        return start;
    }
    @Override
    public MyPoint getEnd() {
        return end;
    }

    public void render(){
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
}
