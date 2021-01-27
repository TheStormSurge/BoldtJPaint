package view.gui;

import model.persistence.ApplicationState;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

import java.awt.*;
import java.io.IOException;

public class DrawRectangle implements ICommand, IUndoable {
    private PaintCanvas canvas;
    private MyPoint start;
    private MyPoint end;
    private int height;
    private int width;

    public DrawRectangle(PaintCanvas c, MyPoint s, MyPoint e){
        canvas=c;
        start=s;
        end=e;
    }
    public void run() {
        //DRAW RECTANGLE TO CANVAS
        Graphics2D graph=canvas.getGraphics2D();
        width=end.getX()-start.getX();
        height= end.getY()-start.getY();
        graph.fillRect(start.getX()-5, start.getY()-70,width,height);
        CommandHistory.add(this);
    }
    public void undo(){
        //UNDO DRAWN RECTANGLE
        Graphics2D mygraph=canvas.getGraphics2D();
        mygraph.setColor(new Color(255,255,255));
        mygraph.fillRect(start.getX()-5, start.getY()-70,width,height);
    }
    public void redo(){
        //REDRAW RECTANGLE
        Graphics2D graph=canvas.getGraphics2D();
        Graphics2D mygraph=canvas.getGraphics2D();
        graph.fillRect(start.getX()-5, start.getY()-70,width,height);
    }
}
