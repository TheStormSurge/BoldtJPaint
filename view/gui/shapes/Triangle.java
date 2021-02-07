package view.gui;

import model.ShapeShadingType;

import java.awt.*;

public class Triangle {
    MyPoint start;
    MyPoint end;
    PaintCanvas canvas;
    Color fill;
    Color outline;
    ShapeShadingType shade;

    public Triangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        start=s;
        end=e;
        canvas=c;
        fill=f;
        outline=o;
        shade=sh;
    }
    public void draw(){
        new DrawTriangle(canvas, start, end,fill,outline,shade).run();
    }
}
