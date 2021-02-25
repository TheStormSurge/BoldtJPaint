package view.interfaces;
import view.gui.MyPoint;

public interface IShape {
    void draw();
    void render();
    void base();
    void move(int xoffset, int yoffset);
    MyPoint getStart();
    MyPoint getEnd();
    IShape clone();
    void highlighted(boolean b);
}
