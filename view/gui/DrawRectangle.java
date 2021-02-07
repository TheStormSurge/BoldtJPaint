package view.gui;

import model.ShapeColor;
import model.persistence.ApplicationState;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;

public class DrawRectangle implements ICommand, IUndoable {
    private PaintCanvas canvas;
    private MyPoint start;
    private MyPoint end;
    private int height;
    private int width;
    private ApplicationState state;

    public DrawRectangle(PaintCanvas c, MyPoint s, MyPoint e,ApplicationState st){
        canvas=c;
        start=s;
        end=e;
        state=st;
    }
    public void run() {
        //DRAW RECTANGLE TO CANVAS
        Graphics2D graph=canvas.getGraphics2D();
        width=end.getX()-start.getX();
        height= end.getY()-start.getY();
        ShapeColor color = state.getActivePrimaryColor();
        System.out.println(color.toString());
        String color_string=color.toString();
        Color realcolor = Color.BLACK;
        try {
            Field field = Color.class.getField(color_string);
            realcolor = (Color)field.get(null);
        }catch(Exception e){
            e.printStackTrace();
        }
        graph.setColor(realcolor);
        graph.fillRect(start.getX(), start.getY(),width,height);
        CommandHistory.add(this);
    }
    public void undo(){
        //UNDO DRAWN RECTANGLE
        Graphics2D mygraph=canvas.getGraphics2D();
        mygraph.setColor(new Color(255,255,255));
        mygraph.fillRect(start.getX(), start.getY(),width,height);
    }
    public void redo(){
        //REDRAW RECTANGLE
        Graphics2D graph=canvas.getGraphics2D();
        Graphics2D mygraph=canvas.getGraphics2D();
        graph.fillRect(start.getX(), start.getY(),width,height);
    }
}
