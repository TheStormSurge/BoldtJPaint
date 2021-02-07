package view.gui;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.IShape;

import java.awt.*;

public class ShapeFactory {
    PaintCanvas canvas;

    public ShapeFactory(PaintCanvas c) {
        canvas=c;
    }
    public IShape createRectangle(MyPoint start, MyPoint end){
        return new Rectangle(canvas,start,end);
    }
    public IShape createTriangle(MyPoint start, MyPoint end){
        return new Triangle(canvas,start,end);
    }
    public IShape createOval(MyPoint start, MyPoint end){
        return new Oval(canvas,start,end);
    }
}
