package generation;

import javafx.scene.canvas.GraphicsContext;

public class Hex extends Tile{

    protected Hex(double x, double y, double scale) {
        super(x, y, scale);
    }

    @Override
    protected void draw(GraphicsContext gc) {
        double[] xPoints = {
                x,
                x+scale/3.0,
                x+(scale/3.0)*2.0,
                x+scale,
                x+(scale/3.0)*2.0,
                x+scale/3.0,
        };
        double[] yPoints = {
                y+0.5*scale,
                y,
                y,
                y+0.5*scale,
                y+scale,
                y+scale
        };
        gc.strokePolygon(xPoints,yPoints,6);
    }
}
