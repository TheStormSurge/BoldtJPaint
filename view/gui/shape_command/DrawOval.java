package view.gui.shape_command;

import model.ShapeShadingType;
import view.gui.CommandHistory;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;
import java.awt.*;


public class DrawOval implements IUndoable, ICommand{

    private PaintCanvas canvas;
    private int height;
    private int width;
    private Color fill;
    private Color outline;
    private String shade;
    private int x;
    private int y;
    private boolean redo = false;


    public DrawOval(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh){
        canvas=c;
        fill=f;
        outline=o;
        shade=sh.toString();
        x=Math.min(s.getX(),e.getX());
        y=Math.min(s.getY(),e.getY());
        width= Math.abs(e.getX()-s.getX());
        height= Math.abs(e.getY()-s.getY());
    }
    public void run() {
        //DRAW OVAL TO CANVAS
        Graphics2D graph=canvas.getGraphics2D();
        if (shade.equals("FILLED_IN")){
            graph.setColor(fill);
            graph.fillOval(x, y,width,height);
        }
        else if (shade.equals("OUTLINE")) {
            graph.setColor(fill);
            graph.drawOval(x, y,width,height);
        }
        else{ //FILLED IN w/ OUTLINE
            graph.setColor(fill);
            graph.fillOval(x, y,width,height);
            graph.setColor(outline);
            graph.drawOval(x, y,width,height);
        }
        if(!this.redo){
            CommandHistory.add(this);}
        redo=false;
    }
    public void undo(){
        //UNDO DRAWN OVAL
        Graphics2D mygraph=canvas.getGraphics2D();
        mygraph.setColor(new Color(255,255,255));
        mygraph.fillOval(x, y,width,height);
        mygraph.drawOval(x, y,width,height);
    }
    public void redo(){
        //REDRAW OVAL
        this.redo=true;
        this.run();
    }
}
