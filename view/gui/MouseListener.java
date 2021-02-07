package view.gui;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.IShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.concurrent.Callable;

public class MouseListener extends MouseAdapter {
    PaintCanvas drawarea;
    MyPoint start;
    MyPoint end;
    ApplicationState state;
    ShapeFactory sf;

    public MouseListener(PaintCanvas canvas,ApplicationState s) {
        drawarea=canvas;
        state=s;
        sf= new ShapeFactory(canvas);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        start=new MyPoint(e.getPoint());
    }

    public void mouseReleased(MouseEvent e) {
        end=new MyPoint(e.getPoint());
        String active_mode=state.getActiveMouseMode().toString();
        if(active_mode.equals("DRAW")){
            String t = state.getActiveShapeType().toString();
            IShape shape;
            switch(t) {
                case "RECTANGLE":
                    shape=sf.createRectangle(start,end);
                    break;
                case "TRIANGLE":
                    shape=sf.createTriangle(start,end);
                    break;
                default :
                    shape=sf.createOval(start,end);
                    break;
            }
            shape.draw(state);
        }
    }
}