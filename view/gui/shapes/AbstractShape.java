package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.gui.ScreenShapes;
import view.gui.shape_command.DrawShape;
import view.gui.state.HighlightState;
import view.gui.state.NormalState;
import view.gui.state.ShapeState;
import view.interfaces.IShape;
import view.interfaces.IStrategy;

import java.awt.*;

public class AbstractShape implements IShape{
    protected MyPoint start;
    protected MyPoint end;
    protected PaintCanvas canvas;
    protected ShapeState state;
    protected Color fill;
    protected Color outline;
    protected String shade;
    protected int x;
    protected int y;
    protected int height;
    protected int width;
    protected MyPoint left;
    protected MyPoint right;
    protected IStrategy strategy;

    public AbstractShape(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        state=new NormalState();
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

    public Color getFill(){
        return fill;
    }
    public String getShade(){
        return shade;
    }
    public Color getOutline(){
        return outline;
    }

    public void draw(){
        ScreenShapes.add(this);
        new DrawShape(this).run();
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public MyPoint getStart() {
        return left;
    }

    public IShape clone(){
        try {return (IShape) super.clone();}
        catch (Exception e){ return this;}
    }

    public void highlighted(boolean b){
        if(b){this.state=new HighlightState();}
        else{this.state=new NormalState();}
    }

    public MyPoint getEnd() {
        return right;
    }

    public void render(){
        this.state.draw(this,canvas);
    }

    public void base(){
        strategy.draw(this);
    }

    public void move(int offsetx, int offsety){
        x=x+offsetx;
        y=y+offsety;
        left= new MyPoint(new Point(x,y));
        right= new MyPoint(new Point(x+width,y+height));
        ScreenShapes.render();
    }
}

