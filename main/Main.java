package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeColor;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.Board;
import view.gui.*;
import view.interfaces.IGuiWindow;
import view.interfaces.IShape;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EnumMap;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        new Board((PaintCanvas) paintCanvas);
        ScreenShapes s = new ScreenShapes((PaintCanvas) paintCanvas);
        MouseListener ml = new MouseListener((PaintCanvas) paintCanvas,appState);
        paintCanvas.addMouseListener(ml);

        // For example purposes only; remove all lines below from your final project.

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        // Filled in rectangle
//        Graphics2D graphics2d = paintCanvas.getGraphics2D();
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
//
        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);
    }
}

