package generation;

import javafx.scene.canvas.GraphicsContext;

public class Tile {
    private double x, y, scale;
    Tile(double x, double y, double scale){
        this.scale = scale;
        this.x = x;
        this.y = y;
    }
    protected void draw(GraphicsContext gc){
        gc.strokeRect(x,y,scale,scale);
    }

    public double getX() {
        return x;
    }

    public double getScale() {
        return scale;
    }

    public double getY() {
        return y;
    }
}
