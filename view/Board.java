package view;
import view.gui.PaintCanvas;

public class Board {
    private static PaintCanvas stored;
    public Board(PaintCanvas g){
        stored=g;
    }
    public static PaintCanvas getCanvas(){
        return stored;
    }
}
