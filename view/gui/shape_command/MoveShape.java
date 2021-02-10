package view.gui.shape_command;

import view.gui.CommandHistory;
import view.gui.MyPoint;
import view.gui.ScreenShapes;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

import java.awt.*;

public class MoveShape implements ICommand, IUndoable {
    IShape shape;
    MyPoint og;
    MyPoint newp;
    MyPoint newstart;
    public MoveShape(IShape s){
        shape=s;
    }
    public void run(){
        og=shape.getStart();
        int x =og.getX()+ newp.getX();
        int y =og.getY()+ newp.getY();
        newstart =new MyPoint(new Point(x,y));
        shape.setStart(newstart);
        CommandHistory.add(this);
    }
    public void undo(){
        shape.setStart(og);
    }
    public void redo(){
        shape.setStart(newstart);
        ScreenShapes.render();
    }
}
