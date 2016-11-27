package generation;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Hex extends Tile{
    private double[] xPoints;
    private double[] yPoints;

    protected Hex(double x, double y, double scale) {
        super(x, y, scale);
        double xHalf  = scale/2;
        double rootThree = Math.sqrt(3);
        double vHalf = rootThree * xHalf;
        double diameter = scale*2;
        xPoints = new double[]{
                x+xHalf,
                x+scale+xHalf,
                x+diameter,
                x+scale+xHalf,
                x+xHalf,
                x
        };
        yPoints = new double[]{
                y,
                y,
                y + vHalf,
                y+2*vHalf,
                y+2*vHalf,
                y+vHalf
        };
    }

    protected static ArrayList<Hex> getHoneycomb(Hex center){
        double x, y, scale ,rootThree,vHalf,xHalf, vFull;
        x = center.getX();
        y = center.getY();
        scale = center.getScale();
        xHalf = scale/2;
        rootThree  = Math.sqrt(3);
        vHalf = rootThree * xHalf;
        vFull = vHalf*2;
        ArrayList<Hex> hexes = new ArrayList<>();
        hexes.add(center);
        hexes.add(new Hex(x,y-vFull,scale));
        hexes.add(new Hex(x,y+vFull,scale));
        hexes.add(new Hex(x-scale-((scale/8)*3)-1,y-vHalf,scale));
        hexes.add(new Hex(x+scale+((scale/8)*3)+1,y-vHalf,scale));
        hexes.add(new Hex(x-scale-((scale/8)*3)-1,y+vHalf,scale));
        hexes.add(new Hex(x+scale+((scale/8)*3)+1,y+vHalf,scale));

        return hexes;
    }

    @Override
    protected void draw(GraphicsContext gc) {
        gc.strokePolygon(xPoints,yPoints,6);
    }
}
