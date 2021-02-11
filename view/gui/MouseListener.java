package view.gui;
import model.ShapeShadingType;
import model.persistence.ApplicationState;
import view.gui.shape_command.MoveShapes;
import view.gui.shapes.ShapeFactory;
import view.interfaces.IShape;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;

public class MouseListener extends MouseAdapter {
    PaintCanvas drawarea;
    MyPoint start;
    MyPoint end;
    ApplicationState state;
    ShapeFactory sf;

    public MouseListener(PaintCanvas canvas,ApplicationState s) {
        drawarea=canvas;
        state=s;
        sf= new ShapeFactory(canvas);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        start=new MyPoint(e.getPoint());
    }

    public void mouseReleased(MouseEvent e) {
        end=new MyPoint(e.getPoint());
        String active_mode=state.getActiveMouseMode().toString();
        ShapeShadingType shade = state.getActiveShapeShadingType();
        String active_shape= state.getActiveShapeType().toString();
        Color fill=Color.BLACK;
        Color outline=Color.WHITE;
        try {
            Field fieldf = Color.class.getField(state.getActivePrimaryColor().toString());
            Field fieldo = Color.class.getField(state.getActiveSecondaryColor().toString());
            fill = (Color)fieldf.get(null);
            outline = (Color)fieldo.get(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if(active_mode.equals("DRAW")){
            IShape shape;
            switch (active_shape){
                case "RECTANGLE":
                    shape=sf.createRectangle(start,end,fill,outline,shade);
                    break;
                case "TRIANGLE":
                    shape=sf.createTriangle(start,end,fill,outline,shade);
                    break;
                case "ELLIPSE":
                    shape=sf.createEllipse(start,end,fill,outline,shade);
                    break;
                default:
                    shape=sf.createRectangle(start,end,fill,outline,shade);
            }
            shape.draw();
        }
        if(active_mode.equals("SELECT")){
            SelectedShapes.clear();
            IShape selector=sf.createRectangle(start,end,Color.CYAN,outline,shade);
            MyPoint select1 =selector.getStart();
            MyPoint select2= selector.getEnd();
            for(IShape rendered: ScreenShapes.getShapes()){
                MyPoint point1 = rendered.getStart();
                MyPoint point2 = rendered.getEnd();
                if(
                select1.getX()<point2.getX()&&
                select2.getX()>point1.getX()&&
                select1.getY()<point2.getY()&&
                select2.getY()>point1.getY()
                ){SelectedShapes.add(rendered);}
            }
        }
        if(active_mode.equals("MOVE")){
            new MoveShapes(end).run();
        }
    }



}