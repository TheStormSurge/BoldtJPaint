package view.gui;

import model.ShapeShadingType;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

import java.awt.*;
import java.io.IOException;

public class DrawTriangle implements IUndoable, ICommand {
    private PaintCanvas canvas;
    private int height;
    private int width;
    private Color fill;
    private Color outline;
    private String shade;
    private int x;
    private int y;
    private boolean redo = false;

    public DrawTriangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        canvas=c;
        fill=f;
        outline=o;
        shade=sh.toString();
        x=Math.min(s.getX(),e.getX());
        y=Math.min(s.getY(),s.getY());
        width= Math.abs(e.getX()-s.getX());
        height= Math.abs(e.getY()-s.getY());
    }
    @Override
    public void run()  {
    }

    @Override
    public void redo() {

    }
    @Override
    public void undo() {

    }
}
