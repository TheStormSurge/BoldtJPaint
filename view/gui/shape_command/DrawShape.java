package view.gui.shape_command;
import view.gui.CommandHistory;
import view.gui.ScreenShapes;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

public class DrawShape implements ICommand, IUndoable {
    private boolean redo = false;
    IShape shape;

    public DrawShape(IShape sha){
        shape=sha;
    }
    public void run() {
        shape.render();
        //System.out.println(shape.getEnd().getX() + " " + shape.getEnd().getY());
        if(!redo){
            CommandHistory.add(this);
        }
    }
    public void undo(){
        ScreenShapes.delete(shape);
        ScreenShapes.render();
    }
    public void redo(){
        redo=true;
        this.run();
        ScreenShapes.add(shape);
    }

}
