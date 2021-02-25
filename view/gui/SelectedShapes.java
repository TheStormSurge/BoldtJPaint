package view.gui;
import view.interfaces.IShape;
import java.util.ArrayList;

public class SelectedShapes {
    private static ArrayList<IShape> list = new ArrayList<>();
    public static void add(IShape s){
        list.add(s);
    }
    public static void clear(){
        for(IShape s: list){s.highlighted(false);}
        list.clear();
        ScreenShapes.render();
    }
    public static ArrayList<IShape> getShapes(){
        return list;
    }
}
