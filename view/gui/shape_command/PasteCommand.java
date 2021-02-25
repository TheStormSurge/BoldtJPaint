package view.gui.shape_command;
import view.gui.Clipboard;
import view.gui.CommandHistory;
import view.gui.ScreenShapes;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;
import java.util.ArrayList;


public class PasteCommand implements ICommand, IUndoable {
    ArrayList<IShape> shapesadded;
    @Override
    public void run() {
        shapesadded=new ArrayList<>();
        for(IShape s : Clipboard.getShapes()){
            IShape newshape = s.clone();
            ScreenShapes.add(newshape);
            shapesadded.add(newshape);
            newshape.move(20, 20);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for(IShape s: shapesadded){ScreenShapes.delete(s);}
        ScreenShapes.render();
    }

    @Override
    public void redo() {
        for(IShape s: shapesadded){ScreenShapes.add(s);}
        ScreenShapes.render();
    }
}