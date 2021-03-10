package view.gui.shape_command;

import view.gui.CommandHistory;
import view.gui.ScreenShapes;
import view.gui.SelectedShapes;
import view.gui.shapes.CompositeShape;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

import java.util.ArrayList;


public class UnGroupCommand implements ICommand, IUndoable {
    ArrayList<IShape> comp = new ArrayList<>();
    ArrayList<IShape> old= new ArrayList<>();
    @Override
    public void run() {
        for(IShape s: SelectedShapes.getShapes()){
            if(s.getClass().toString().indexOf("CompositeShape")>-1){
                for(IShape j: ((CompositeShape) s).getComposition()){
                    comp.add(j);
                }
                old.add(s);
                ScreenShapes.delete(s);
            }
        }
        for(IShape s: comp){
            ScreenShapes.add(s);
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for(IShape o : old){
            ScreenShapes.add(o);
        }
        for(IShape n : comp){
            ScreenShapes.delete(n);
        }
    }

    @Override
    public void redo() {
        for(IShape o : old){
            ScreenShapes.delete(o);
        }
        for(IShape n : comp){
            ScreenShapes.add(n);
        }

    }
}
