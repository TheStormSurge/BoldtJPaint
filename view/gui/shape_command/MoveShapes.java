package view.gui.shape_command;
import view.gui.CommandHistory;
import view.gui.MyPoint;
import view.gui.SelectedShapes;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

import java.util.ArrayList;

public class MoveShapes implements ICommand, IUndoable {

    MyPoint newpoint;
    ArrayList<MyPoint> old = new ArrayList<>();

    public MoveShapes(MyPoint newpoint){
        this.newpoint=newpoint;
    }
    public void run(){
        for(IShape shape : SelectedShapes.getShapes()){
            old.add(shape.getStart());
            shape.move(newpoint);
        }
        CommandHistory.add(this);
    }
    public void undo(){
        ArrayList<IShape> shapes = SelectedShapes.getShapes();
        for(int i=0;i<shapes.size();i++){
            shapes.get(i).move(old.get(i));
        }
    }
    public void redo(){
        for(IShape shape : SelectedShapes.getShapes()) {
            shape.move(newpoint);
        }
    }
}
