package view.gui.state;

import view.gui.PaintCanvas;
import view.interfaces.IShape;

public interface ShapeState {
    void draw(IShape s, PaintCanvas p);
}
