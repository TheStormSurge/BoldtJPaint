package view.interfaces;
import view.gui.MyPoint;

public interface IShape {
    void draw();
    void render();
    MyPoint getStart();
    MyPoint getEnd();
}
