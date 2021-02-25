package view.gui.shape_command;
import view.gui.CommandHistory;
import view.gui.ScreenShapes;
import view.gui.SelectedShapes;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;
import java.util.ArrayList;


public class DeleteCommand implements ICommand, IUndoable {

    ArrayList<IShape> shapesdeleted;
    @Override
    public void run(){
        shapesdeleted=new ArrayList<>();
        for(IShape s: SelectedShapes.getShapes()){
            shapesdeleted.add(s);
            ScreenShapes.delete(s);
        }
        ScreenShapes.render();
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for(IShape s: shapesdeleted){ScreenShapes.add(s);}
        ScreenShapes.render();
    }

    @Override
    public void redo() {
        for(IShape s: shapesdeleted){ScreenShapes.delete(s);}
        ScreenShapes.render();
    }
}
