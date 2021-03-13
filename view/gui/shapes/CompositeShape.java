package view.gui.shapes;
import view.Board;
import view.gui.MyPoint;
import view.gui.ScreenShapes;
import view.gui.state.HighlightState;
import view.gui.state.NormalState;
import view.gui.state.ShapeState;
import view.gui.strategies.RectangleStrat;
import view.interfaces.IShape;
import view.interfaces.IStrategy;

import java.awt.*;
import java.util.ArrayList;

public class CompositeShape implements IShape, Cloneable {
    private ArrayList<IShape> grouped = new ArrayList<>();
    MyPoint start;
    MyPoint end;
    ShapeState state;
    IStrategy strategy;
    int width;
    int height;

    public CompositeShape(){
        state=new NormalState();
        strategy=new RectangleStrat();
    }

    public void add(IShape s) {
        grouped.add(s);
        if(grouped.size()==1) {
            start = grouped.get(0).getStart();
            end = grouped.get(0).getEnd();
            int leftmostx=grouped.get(0).getStart().getX();
            int lowesty=grouped.get(0).getStart().getY();
            int rightmostx=grouped.get(0).getEnd().getX();
            int highesty=grouped.get(0).getEnd().getY();
        }
        int leftmostx=start.getX();
        int lowesty=start.getY();
        int rightmostx= end.getX();
        int highesty= end.getY();
        for(IShape sh : grouped){
            if(sh.getStart().getX()<leftmostx){
                leftmostx=sh.getStart().getX();
            }
            if(sh.getStart().getY()<lowesty){
                lowesty=sh.getStart().getY();
            }
            if(sh.getEnd().getX()>rightmostx){
                rightmostx=sh.getEnd().getX();
            }
            if(sh.getEnd().getY()>highesty){
                highesty=sh.getEnd().getY();
            }
        }
        start= new MyPoint(new Point(leftmostx,lowesty));
        end= new MyPoint(new Point(rightmostx,highesty));
        width= Math.abs(end.getX()-start.getX());
        height= Math.abs(end.getY()-start.getY());
    }

    public ArrayList<IShape> getComposition() {
        return grouped;
    }

    public void replace(ArrayList<IShape> replacement){
        grouped = replacement;
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
    public void base(boolean highlighted) {
        if(highlighted){strategy.draw(this,true);}
        else {
            for (IShape shape : grouped) {
                shape.base(false);
            }
        }
    }

    @Override
    public void move(int xoffset, int yoffset) {
        for(IShape shape : grouped){
            shape.move(xoffset,yoffset);
        }
        start=new MyPoint(new Point(start.getX()+xoffset,start.getY()+yoffset));
        end=new MyPoint(new Point(end.getX()+xoffset,end.getY()+yoffset));
        ScreenShapes.render();
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
        ArrayList<IShape> newshapes = new ArrayList<>();
        for(IShape s: grouped){ IShape n = s.clone();newshapes.add(n);}
        try {
            CompositeShape n= (CompositeShape)super.clone();
            n.replace(newshapes);
            return (IShape) n;
        }
        catch (Exception e){e.printStackTrace();return p;}
    }

    @Override
    public void highlighted(boolean b){
        if(b){this.state=new HighlightState();}
        else{this.state=new NormalState();}
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
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
