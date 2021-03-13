package view.gui.strategies;
import view.Board;
import view.gui.MyPoint;
import view.interfaces.IShape;
import view.interfaces.IStrategy;

import java.awt.*;

public class OvalStrat implements IStrategy {
    public void draw(IShape s, boolean highlight) {
        MyPoint st=s.getStart();
        MyPoint end=s.getEnd();
        Graphics2D graph= Board.getCanvas().getGraphics2D();
        int x=s.getStart().getX();
        int y=s.getStart().getY();
        int height= s.getHeight();
        int width = s.getWidth();
        String shade = s.getShade();
        Color outline = s.getOutline();
        Color fill =s.getFill();
        if(!highlight) {
            if (shade.equals("FILLED_IN")) {
                graph.setColor(fill);
                graph.fillOval(x, y, width, height);
            } else if (shade.equals("OUTLINE")) {
                graph.setColor(fill);
                graph.setStroke(new BasicStroke(5));
                graph.drawOval(x, y, width, height);
            } else { //FILLED IN w/ OUTLINE
                graph.setColor(fill);
                graph.fillOval(x, y, width, height);
                graph.setColor(outline);
                graph.setStroke(new BasicStroke(5));
                graph.drawOval(x, y, width, height);
            }
        }
        else{
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graph.setStroke(stroke);
            graph.setColor(Color.BLACK);
            graph.drawOval(st.getX(), st.getY(), end.getX() - st.getX(), end.getY() - st.getY());
        }
    }
}
