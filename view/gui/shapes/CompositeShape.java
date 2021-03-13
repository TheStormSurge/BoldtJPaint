package view.gui.shapes;
import view.Board;
import view.gui.MyPoint;
import view.gui.state.HighlightState;
import view.gui.state.NormalState;
import view.gui.state.ShapeState;
import view.interfaces.IShape;

import java.awt.*;
import java.util.ArrayList;

public class CompositeShape implements IShape, Cloneable {
    private ArrayList<IShape> grouped = new ArrayList<>();
    MyPoint start;
    MyPoint end;
    ShapeState state;

    public CompositeShape(){
        state=new NormalState();
    }

    public void add(IShape s) {
        //TODO DRAW OUTLINE
        grouped.add(s);
        start=grouped.get(0).getStart();
        end=grouped.get(0).getEnd();
        for(IShape sh : grouped){
            if(sh.getStart().getX()<start.getX()){
                start=sh.getStart();
            }
            if(sh.getEnd().getX()>end.getX()){
                end=sh.getEnd();
            }
        }
    }

    public ArrayList<IShape> getComposition() {
        return grouped;
    }

    @Override
    public void draw() {
        for(IShape shape : grouped){shape.draw();}
    }

    @Override
    public void render() {
        this.state.draw(this, Board.getCanvas());
        for(IShape shape : grouped){shape.render();}
    }

    @Override
    public void base() {
        for(IShape shape : grouped){shape.base();}
    }

    @Override
    public void move(int xoffset, int yoffset) {
        for(IShape shape : grouped){
            shape.move(xoffset,yoffset);
        }
    }

    @Override
    public MyPoint getStart() {
        return start;
    }

    @Override
    public MyPoint getEnd() {
        return end;
    }

    @Override
    public IShape clone(){
        CompositeShape p =this;
        try {return (IShape)super.clone();}
        catch (Exception e){e.printStackTrace();return p;}
    }

    @Override
    public void highlighted(boolean b){
        if(b){this.state=new HighlightState();}
        else{this.state=new NormalState();}
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public String getShade() {
        return null;
    }

    @Override
    public Color getOutline() {
        return null;
    }

    @Override
    public Color getFill() {
        return null;
    }
}
