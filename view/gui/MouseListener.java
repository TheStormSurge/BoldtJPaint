package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    JComponent drawarea;
    MyPoint start;
    MyPoint end;

    public MouseListener(JComponent canvas) {
        drawarea=canvas;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        start= new MyPoint(e.getX(),e.getY());
    }
    public void mouseReleased(MouseEvent e) {
        end= new MyPoint(e.getX(),e.getY());
        Graphics graphics = drawarea.getGraphics();
        graphics.fillRect(
                start.getX()-5,
                start.getY()-70,
                end.getX()-start.getX(),
                end.getY()- start.getY()
        );
    }





}
class MyPoint{
    int xcord;
    int ycord;

    public MyPoint(double x, double y){
        xcord= (int) x;
        ycord=(int) y;
    }
    public int getX(){
        return xcord;
    }
    public int getY(){
        return ycord;
    }
}