package view.gui.shape_command;

import view.gui.CommandHistory;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

import java.util.ArrayList;

public class UnGroupCommand implements ICommand, IUndoable {
    ArrayList<IShape> tracker;
    ArrayList<IShape> othertracker;

    @Override
    public void run() {
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {

    }
}
