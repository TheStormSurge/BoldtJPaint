package view.gui.shapes;
import model.ShapeShadingType;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.interfaces.IShape;

import java.awt.*;

public class ShapeFactory {
    PaintCanvas canvas;

    public ShapeFactory(PaintCanvas c) {
        canvas=c;
    }
    public IShape createRectangle(MyPoint start, MyPoint end, Color fill, Color outline, ShapeShadingType sh){
        return new Rectangle(canvas,start,end,fill,outline,sh);
    }
    public IShape createTriangle(MyPoint start, MyPoint end, Color fill, Color outline, ShapeShadingType sh){
        return new Triangle(canvas,start,end,fill,outline,sh);
    }
    public IShape createEllipse(MyPoint start, MyPoint end, Color fill, Color outline, ShapeShadingType sh){
        return new Ellipse(canvas,start,end,fill,outline,sh);
    }
}
