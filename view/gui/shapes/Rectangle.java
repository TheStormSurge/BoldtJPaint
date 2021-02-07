package view.gui;
import model.ShapeShadingType;
import view.interfaces.IShape;
import java.awt.*;

public class Rectangle implements IShape {
    MyPoint start;
    MyPoint end;
    PaintCanvas canvas;
    Color fill;
    Color outline;
    ShapeShadingType shade;

    public Rectangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        start=s;
        end=e;
        canvas=c;
        fill=f;
        outline=o;
        shade=sh;
    }
    public void draw(){
        new DrawRectangle(canvas, start, end,fill,outline,shade).run();
    }
}