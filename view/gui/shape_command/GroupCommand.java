package view.gui.shape_command;

import view.gui.CommandHistory;
import view.gui.ScreenShapes;
import view.gui.SelectedShapes;
import view.gui.shapes.CompositeShape;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

import java.util.ArrayList;

public class GroupCommand implements ICommand, IUndoable {
    CompositeShape mygroup;

    @Override
    public void run() {
        CompositeShape group=new CompositeShape();
        for (IShape s: SelectedShapes.getShapes()) {
            ScreenShapes.delete(s);
            group.add(s);
        }
        mygroup=group;
        ScreenShapes.add(group);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        ArrayList<IShape> shapes = mygroup.getComposition();
        for(IShape s: shapes){
            ScreenShapes.add(s);
        }
        ScreenShapes.delete(mygroup);
    }

    @Override
    public void redo() {
        for(IShape s: mygroup.getComposition()){
            ScreenShapes.delete(s);
        }
        ScreenShapes.add(mygroup);
    }
}
