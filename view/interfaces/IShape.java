package view.interfaces;
import view.gui.MyPoint;

public interface IShape {
    void draw();
    void render();
    void move(MyPoint p);
    void setStart(MyPoint p);
    MyPoint getStart();
    MyPoint getEnd();
}
