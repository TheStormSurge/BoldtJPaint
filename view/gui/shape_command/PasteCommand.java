package view.gui.shape_command;
import view.gui.Clipboard;
import view.gui.CommandHistory;
import view.gui.ScreenShapes;
import view.gui.SelectedShapes;
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
            newshape.move(40, 40);
        }
        CommandHistory.add(this);
        SelectedShapes.clear();
        for(IShape s : ScreenShapes.getShapes()){s.highlighted(false);}
        ScreenShapes.render();
    }

    @Override
    public void undo() {
        for(IShape s: shapesadded){ScreenShapes.delete(s);}
    }

    @Override
    public void redo() {
        for(IShape s: shapesadded){ScreenShapes.add(s);}
        for(IShape s : ScreenShapes.getShapes()){s.highlighted(false);}
    }
}
