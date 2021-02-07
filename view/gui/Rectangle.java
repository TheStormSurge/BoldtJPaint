package view.gui;
import model.persistence.ApplicationState;
import view.interfaces.IShape;
import java.awt.*;

public class Rectangle implements IShape {
    MyPoint start;
    MyPoint end;
    PaintCanvas canvas;

    public Rectangle(PaintCanvas c, MyPoint s, MyPoint e){
        start=s;
        end=e;
        canvas=c;
    }
    public void draw(ApplicationState st){
        new DrawRectangle(canvas, start, end,st).run();
    }
}