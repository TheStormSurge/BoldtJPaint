package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.ScreenShapes;
import view.gui.shape_command.DrawShape;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.interfaces.IShape;
import java.awt.*;

public class Rectangle implements IShape {
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
    MyPoint left;
    MyPoint right;

    public Rectangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
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
        left = new MyPoint(new Point(x,y));
        right= new MyPoint(new Point(x+width,y+height));
    }
    public void draw(){
        ScreenShapes.add(this);
        new DrawShape(this).run();
    }
    public MyPoint getStart() {
        return left;
    }
    @Override
    public MyPoint getEnd() {
        return right;
    }
    public void render(){
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

    public void move(MyPoint e){
        //new MoveShape(this,e).run();
        //ScreenShapes.render()
        //System.out.println("MOVING");
        x=e.getX();
        y=e.getY();
        left= new MyPoint(new Point(x,y));
        right= new MyPoint(new Point(x+width,y+height));
        ScreenShapes.render();
    }

    public void setStart(MyPoint e){
        x=e.getX();
        y=e.getY();
    }


}