package view.gui;

import java.awt.*;

public class MyPoint{
    int xcord;
    int ycord;

    public MyPoint(Point x){
        xcord=(int)x.getX();
        ycord=(int)x.getY();
    }
    public int getX(){
        return xcord;
    }
    public int getY(){
        return ycord;
    }
}
