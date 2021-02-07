package view.gui;
import model.ShapeShadingType;
import view.gui.shapes.Rectangle;
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
}
