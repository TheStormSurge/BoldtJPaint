package view.gui.strategies;
import view.Board;
import view.interfaces.IShape;
import view.interfaces.IStrategy;

import java.awt.*;

public class RectangleStrat implements IStrategy {
    public void draw(IShape s){
        Graphics2D graph= Board.getCanvas().getGraphics2D();
        int x=s.getStart().getX();
        int y=s.getStart().getY();
        int height= s.getHeight();
        int width = s.getWidth();
        String shade = s.getShade();
        Color outline = s.getOutline();
        Color fill =s.getFill();

        if (shade.equals("FILLED_IN")){
            graph.setColor(fill);
            graph.fillRect(x, y,width,height);
        }
        else if (shade.equals("OUTLINE")) {
            graph.setColor(fill);
            graph.setStroke(new BasicStroke(5));
            graph.drawRect(x, y,width,height);
        }
        else{ //FILLED IN w/ OUTLINE
            graph.setColor(fill);
            graph.fillRect(x, y,width,height);
            graph.setColor(outline);
            graph.setStroke(new BasicStroke(5));
            graph.drawRect(x, y,width,height);
        }
    }
}
