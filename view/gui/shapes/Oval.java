package view.gui.shapes;

import model.ShapeShadingType;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.gui.shape_command.DrawOval;
import view.interfaces.IShape;

import java.awt.*;

public class Oval implements IShape {
    MyPoint start;
    MyPoint end;
    PaintCanvas canvas;
    Color fill;
    Color outline;
    ShapeShadingType shade;

    public Oval(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        start=s;
        end=e;
        canvas=c;
        fill=f;
        outline=o;
        shade=sh;
    }
    public void draw() {
        new DrawOval(canvas, start, end,fill,outline,shade).run();
    }
}
