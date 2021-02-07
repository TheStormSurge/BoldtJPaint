package view.gui;
import model.persistence.ApplicationState;
import view.interfaces.IShape;

public class Oval implements IShape {
    MyPoint start;
    MyPoint end;
    PaintCanvas canvas;

    public Oval(PaintCanvas c, MyPoint s, MyPoint e){
        start=s;
        end=e;
        canvas=c;
    }
    public void draw(ApplicationState st){
        new DrawRectangle(canvas, start, end,st);
    }
}