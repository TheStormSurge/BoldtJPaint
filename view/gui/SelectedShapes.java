package view.gui;

import view.interfaces.IShape;

import java.util.ArrayList;

public class SelectedShapes {
    private static ArrayList<IShape> list = new ArrayList<>();
    public static void add(IShape s){
        list.add(s);
        System.out.println(list);
    }
    public static void clear(){
        list.clear();
    }
}
