package view.gui.shape_command;
import view.gui.CommandHistory;
import view.gui.SelectedShapes;
import view.gui.Clipboard;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;
import java.util.ArrayList;

public class CopyCommand implements ICommand, IUndoable {
    ArrayList<IShape> shapes;
    @Override
    public void run()  {
        Clipboard.clear();
        shapes=new ArrayList<IShape>();
        for(IShape s : SelectedShapes.getShapes()){
            Clipboard.add(s);
            shapes.add(s);
        }
        CommandHistory.add(this);
    }
    @Override
    public void undo() {Clipboard.clear();}

    @Override
    public void redo() {
        for(IShape s : shapes){Clipboard.add(s);}
    }
}