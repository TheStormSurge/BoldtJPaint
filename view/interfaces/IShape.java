package view.interfaces;
import view.gui.MyPoint;

public interface IShape {
    void draw();
    void render();
    void move(int xoffset, int yoffset);
    MyPoint getStart();
    MyPoint getEnd();
}
