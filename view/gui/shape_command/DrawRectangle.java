package view.gui.shape_command;
import model.ShapeShadingType;
import view.gui.CommandHistory;
import view.gui.MyPoint;
import view.gui.PaintCanvas;
import view.gui.ScreenShapes;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

import java.awt.*;


public class DrawRectangle implements ICommand, IUndoable {
    private PaintCanvas canvas;
    private int height;
    private int width;
    private Color fill;
    private Color outline;
    private String shade;
    private int x;
    private int y;
    private boolean redo = false;
    int id;
    IShape todraw;

    public DrawRectangle(PaintCanvas c, MyPoint s, MyPoint e, Color f, Color o, ShapeShadingType sh, int id, IShape th){
        canvas=c;
        fill=f;
        outline=o;
        shade=sh.toString();
        x=Math.min(s.getX(),e.getX());
        y=Math.min(s.getY(),e.getY());
        width= Math.abs(e.getX()-s.getX());
        height= Math.abs(e.getY()-s.getY());
        todraw=th;
    }
    public void run() {
        //DRAW RECTANGLE TO CANVAS
        Graphics2D graph=canvas.getGraphics2D();
        if (shade.equals("FILLED_IN")){
            graph.setColor(fill);
            graph.fillRect(x, y,width,height);
        }
        else if (shade.equals("OUTLINE")) {
            graph.setColor(fill);
            graph.drawRect(x, y,width,height);
        }
        else{ //FILLED IN w/ OUTLINE
            graph.setColor(fill);
            graph.fillRect(x, y,width,height);
            graph.setColor(outline);
            graph.drawRect(x, y,width,height);
        }
        if(!redo){
            CommandHistory.add(this);
        }
    }

    public void otherRun(){
        Graphics2D graph=canvas.getGraphics2D();
        if (shade.equals("FILLED_IN")){
            graph.setColor(fill);
            graph.fillRect(x, y,width,height);
        }
        else if (shade.equals("OUTLINE")) {
            graph.setColor(fill);
            graph.drawRect(x, y,width,height);
        }
        else{ //FILLED IN w/ OUTLINE
            graph.setColor(fill);
            graph.fillRect(x, y,width,height);
            graph.setColor(outline);
            graph.drawRect(x, y,width,height);
        }
    }

    public void undo(){
        //UNDO DRAWN RECTANGLE
        Graphics2D mygraph=canvas.getGraphics2D();
        mygraph.setColor(new Color(255,255,255));
        //mygraph.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());;
        mygraph.fillRect(x, y,width,height);
        mygraph.drawRect(x, y,width,height);
        ScreenShapes.delete(todraw);
        ScreenShapes.render();
    }
    public void redo(){
//        //REDRAW RECTANGLE
        redo=true;
        this.run();
        ScreenShapes.add(todraw);
//        ScreenShapes.render();
        System.out.println("REDO COMMAND");
    }
    public void otherrun(){

    }
}
