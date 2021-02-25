package view.gui.shapes;

import model.ShapeShadingType;
import view.gui.ScreenShapes;
import view.gui.shape_command.DrawShape;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.gui.state.HighlightState;
import view.gui.state.NormalState;
import view.gui.state.ShapeState;
import view.interfaces.IShape;

import java.awt.*;

public class Triangle implements IShape,Cloneable {
    public MyPoint start;
    public MyPoint end;
    ShapeState state;
    PaintCanvas canvas;
    Color fill;
    Color outline;
    String shade;
    int[] xs;
    int[] ys;
    MyPoint left;
    MyPoint right;
    int width;
    int height;
    int x;
    int y;

    public Triangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        state=new NormalState();
        start=s;
        end=e;
        canvas=c;
        fill=f;
        outline=o;
        canvas=c;
        fill=f;
        outline=o;
        shade=sh.toString();
        width= Math.abs(e.getX()-s.getX());
        height= Math.abs(e.getY()-s.getY());
        x=Math.min(s.getX(),e.getX());
        y=Math.min(s.getY(),e.getY());
        left = new MyPoint(new Point(x,y));
        right= new MyPoint(new Point(x+width,y+height));
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

    @Override
    public void highlighted(boolean b) {
        if(b){this.state=new HighlightState();}
        else{this.state=new NormalState();}
    }

    public void draw(){
        ScreenShapes.add(this);
        new DrawShape(this).run();
    }
    public IShape clone(){
        Triangle p =this;
        try {return (IShape)super.clone();}
        catch (Exception e){e.printStackTrace();return p;}
    }
    public MyPoint getStart() {
        return left;
    }
    @Override
    public MyPoint getEnd() { return right; }

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
    public void render(){
        this.state.draw(this,canvas);
    }
}
