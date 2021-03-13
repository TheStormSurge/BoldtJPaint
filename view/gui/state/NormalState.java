package view.gui.state;

import view.gui.PaintCanvas;
import view.interfaces.IShape;

public class NormalState implements ShapeState {
    @Override
    public void draw(IShape s, PaintCanvas p) {
        s.base(false);
    }
}
