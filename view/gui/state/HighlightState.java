package view.gui.state;

import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.interfaces.IShape;

import java.awt.*;

public class HighlightState implements ShapeState {
    @Override
    public void draw(IShape s, PaintCanvas p) {
        s.base();
        MyPoint st=s.getStart();
        MyPoint end=s.getEnd();
        Graphics2D graphics2d = p.getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(st.getX(), st.getY(), end.getX()-st.getX(), end.getY()-st.getY());
    }
}
