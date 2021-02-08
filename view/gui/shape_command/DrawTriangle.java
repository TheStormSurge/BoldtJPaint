package view.gui.shape_command;

import model.ShapeShadingType;
import view.gui.CommandHistory;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

import java.awt.*;

public class DrawTriangle implements IUndoable, ICommand {
    private PaintCanvas canvas;
    private Color fill;
    private Color outline;
    private String shade;
    private boolean redo = false;
    int[] xs;
    int[] ys;

    public DrawTriangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        int[] calcx = {s.getX(),e.getX(),s.getX()};
        int[] calcy = {s.getY(),e.getY(), e.getY()};
        xs=calcx;
        ys=calcy;
        canvas=c;
        fill=f;
        outline=o;
        shade=sh.toString();
    }
    @Override
    public void run(){
        Graphics2D graph = canvas.getGraphics2D();

        if (shade.equals("FILLED_IN")){
            graph.setColor(fill);
            graph.fillPolygon(xs,ys,3);
        }
        else if (shade.equals("OUTLINE")) {
            graph.setColor(fill);
            graph.drawPolygon(xs,ys,3);
        }
        else{ //FILLED IN w/ OUTLINE
            graph.setColor(fill);
            graph.fillPolygon(xs,ys,3);
            graph.setColor(outline);
            graph.drawPolygon(xs, ys,3);
        }

        if(!this.redo){
            CommandHistory.add(this);}
        redo=false;
    }
    @Override
    public void redo() {
        this.redo=true;
        this.run();
    }
    @Override
    public void undo() {
        //UNDO DRAWN TRIANGLE
        Graphics2D mygraph=canvas.getGraphics2D();
        mygraph.setColor(new Color(255,255,255));
        mygraph.fillPolygon(xs, ys,3);
        mygraph.drawPolygon(xs, ys,3);
    }
}
