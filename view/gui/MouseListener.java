package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    PaintCanvas drawarea;
    MyPoint start;
    MyPoint end;

    public MouseListener(PaintCanvas canvas) {
        drawarea=canvas;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        start=new MyPoint(e.getPoint());
    }
    public void mouseReleased(MouseEvent e) {
        end=new MyPoint(e.getPoint());
        Graphics2D graphics = drawarea.getGraphics2D();
        new DrawRectangle(drawarea, start, end).run();
    }
}

