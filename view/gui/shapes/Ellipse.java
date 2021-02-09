package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.ScreenShapes;
import view.gui.shape_command.DrawShape;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.interfaces.IShape;
import java.awt.*;

public class Ellipse implements IShape {
    public MyPoint start;
    public MyPoint end;
    PaintCanvas canvas;
    Color fill;
    Color outline;
    String shade;
    private int x;
    private int y;
    private int height;
    private int width;

    public Ellipse(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        start=s;
        end=e;
        canvas=c;
        fill=f;
        outline=o;
        shade=sh.toString();
        x=Math.min(s.getX(),e.getX());
        y=Math.min(s.getY(),e.getY());
        width= Math.abs(e.getX()-s.getX());
        height= Math.abs(e.getY()-s.getY());
    }

    public void draw(){
        ScreenShapes.add(this);
        new DrawShape(this).run();
    }
    @Override
    public MyPoint getStart() {
        return start;
    }
    @Override
    public MyPoint getEnd() {
        return end;
    }

    public void render(){
        Graphics2D graph=canvas.getGraphics2D();
        if (shade.equals("FILLED_IN")){
            graph.setColor(fill);
            graph.fillOval(x, y,width,height);
        }
        else if (shade.equals("OUTLINE")) {
            graph.setColor(fill);
            graph.setStroke(new BasicStroke(5));
            graph.drawOval(x, y,width,height);
        }
        else{ //FILLED IN w/ OUTLINE
            graph.setColor(fill);
            graph.fillOval(x, y,width,height);
            graph.setColor(outline);
            graph.setStroke(new BasicStroke(5));
            graph.drawOval(x, y,width,height);
        }
    }

}