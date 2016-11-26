package generation;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Hex extends Tile{

    protected Hex(double x, double y, double scale) {
        super(x, y, scale);
    }

    protected static ArrayList<Hex> getHoneycomb(Hex center){
        double x, y, scale;
        x = center.getX();
        y = center.getY();
        scale = center.getScale();
        ArrayList<Hex> hexes = new ArrayList<>();
        hexes.add(center);
        hexes.add(new Hex(x-scale,y,scale));
        hexes.add(new Hex(x+scale,y,scale));
        hexes.add(new Hex(x,y-scale,scale));
        hexes.add(new Hex(x,y+scale,scale));
        hexes.add( new Hex(x+scale/2,y+scale/2,scale));
        hexes.add(new Hex(x+scale/2,y-scale/2,scale));
        hexes.add(new Hex(x-scale/2,y+scale/2,scale));
        hexes.add(new Hex(x-scale/2,y-scale/2,scale));

        return hexes;
    }

    @Override
    protected void draw(GraphicsContext gc) {
        double[] xPoints = {
                getX(),
                getY()+getScale()/3.0,
                getX()+(getScale()/3.0)*2.0,
                getX()+getScale(),
                getX()+(getScale()/3.0)*2.0,
                getX()+getScale()/3.0,
        };
        double[] yPoints = {
                getY()+0.5*getScale(),
                getY(),
                getY(),
                getY()+0.5*getScale(),
                getY()+getScale(),
                getY()+getScale()
        };
        gc.strokePolygon(xPoints,yPoints,6);
    }
}
