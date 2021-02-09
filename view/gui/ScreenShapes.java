package view.gui;

import view.interfaces.IShape;

import java.awt.*;
import java.util.ArrayList;

public class ScreenShapes {
    private static ArrayList<IShape> list = new ArrayList<>();
    private static Graphics2D g;
    private static PaintCanvas p;

    public ScreenShapes(PaintCanvas pa){
        g= pa.getGraphics2D();
        p=pa;
    }
    public static void delete(IShape s){
        list.remove(s);
    }
    public static void add(IShape s){
        list.add(s);
    }
    public static void render(){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,p.getWidth(),p.getHeight());
        for(IShape s : list){s.render();}
    }
    public static ArrayList<IShape> getShapes(){
        return list;
    }

}
