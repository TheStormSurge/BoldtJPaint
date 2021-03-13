package view.gui.strategies;
import view.Board;
import view.gui.shapes.Triangle;
import view.interfaces.IShape;
import view.interfaces.IStrategy;

import java.awt.*;

public class TraingleStrat implements IStrategy {
    @Override
    public void draw(IShape s, boolean highlight) {
        Graphics2D graph= Board.getCanvas().getGraphics2D();
        String shade = s.getShade();
        Color outline = s.getOutline();
        Color fill =s.getFill();
        Triangle tri= (Triangle) s;
        int[] xs = tri.getXs();
        int[] ys = tri.getYs();
        if(!highlight) {
            if (shade.equals("FILLED_IN")) {
                graph.setColor(fill);
                graph.fillPolygon(xs, ys, 3);
            } else if (shade.equals("OUTLINE")) {
                graph.setColor(fill);
                graph.setStroke(new BasicStroke(5));
                graph.drawPolygon(xs, ys, 3);
            } else { //FILLED IN w/ OUTLINE
                graph.setColor(fill);
                graph.fillPolygon(xs, ys, 3);
                graph.setColor(outline);
                graph.setStroke(new BasicStroke(5));
                graph.drawPolygon(xs, ys, 3);
            }
        }
        else{
            Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graph.setStroke(stroke);
            graph.setColor(Color.BLACK);
            graph.drawPolygon(xs,ys,3);
        }
    }
}
