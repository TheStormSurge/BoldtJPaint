package view.gui;
import view.interfaces.IShape;
import java.util.ArrayList;
public class Clipboard {
    private static ArrayList<IShape> list = new ArrayList<>();
    public static void add(IShape s){
        list.add(s);
    }
    public static void clear(){
        list.clear();
    }

    public static ArrayList<IShape> getShapes(){
        return list;
    }
}
