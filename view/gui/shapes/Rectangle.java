package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.ScreenShapes;
import view.gui.shape_command.DrawRectangle;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.interfaces.IShape;
import java.awt.*;

public class Rectangle implements IShape {
    MyPoint start;
    MyPoint end;
    PaintCanvas canvas;
    Color fill;
    Color outline;
    ShapeShadingType shade;
    int id;

    public Rectangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        start=s;
        end=e;
        canvas=c;
        fill=f;
        outline=o;
        shade=sh;
        ScreenShapes.add(this);
    }
    public void draw(){
        new DrawRectangle(canvas, start, end,fill,outline,shade,id,this).run();
    }
    public void reRender(){
        new DrawRectangle(canvas, start, end,fill,outline,shade,id,this).otherrun();
    }
}