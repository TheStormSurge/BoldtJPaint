package view.gui.shape_command;
import view.gui.CommandHistory;
import view.gui.MyPoint;
import view.gui.SelectedShapes;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

import java.util.ArrayList;

public class MoveShapes implements ICommand, IUndoable {
    int xoffset;
    int yoffset;
    ArrayList<MyPoint> old = new ArrayList<>();

    public MoveShapes(int xoffset, int yoffset){
        this.xoffset=xoffset;
        this.yoffset=yoffset;
    }
    public void run(){
        for(IShape shape : SelectedShapes.getShapes()){
            old.add(shape.getStart());
            shape.move(xoffset,yoffset);
        }
        CommandHistory.add(this);
    }
    public void undo(){
        ArrayList<IShape> shapes = SelectedShapes.getShapes();
        for(int i=0;i<shapes.size();i++){
            shapes.get(i).move(xoffset*-1, yoffset*-1);
        }
    }
    public void redo(){
        for(IShape shape : SelectedShapes.getShapes()) {
            shape.move(xoffset,yoffset);
        }
    }
}
