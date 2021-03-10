package view.gui.shapes;

import view.gui.MyPoint;
import view.interfaces.IShape;

import java.util.ArrayList;

public class CompositeShape implements IShape {
    private ArrayList<IShape> grouped = new ArrayList<>();
    MyPoint start;
    MyPoint end;

    public void add(IShape s) {
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

    public void remove(IShape s){
        grouped.remove(s);
    }

    public ArrayList<IShape> getComposition() {
        return grouped;
    }

    @Override
    public void draw() {
        for(IShape shape : grouped){
            shape.draw();
        }
    }

    @Override
    public void render() {
        for(IShape shape : grouped){
            shape.render();
        }
    }

    @Override
    public void base() {
        for(IShape shape : grouped){
            shape.base();
        }
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
    public IShape clone() {
        return null;
    }

    @Override
    public void highlighted(boolean b) {
        for(IShape shape : grouped){
            shape.highlighted(b);
        }
    }
}
