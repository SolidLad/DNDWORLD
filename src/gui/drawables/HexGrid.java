package gui.drawables;

import java.awt.*;

public class HexGrid implements Drawable{
    private Polygon[][] arr;
    private int height, width;
    public HexGrid(int frameWidth, int frameHeight, int height, int width, int scaleMiles){
        int widthHexs, heightHexs;
        this.width = frameWidth;
        this.height = frameHeight;
        int scale = width / scaleMiles;
        widthHexs = height/scale;
        heightHexs = width/scale;
        arr = new Polygon[widthHexs][heightHexs];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int[] xArr = {
                        scale*i, scale*i + scale/3, scale*i + (scale/3)*2,scale*i + scale, scale*i + (scale/3)*2, scale*i + scale/3
                };
                int[] yArr = {
                        scale*j + scale/2, scale*j, scale*j, scale*j + scale/2, scale*j + scale, scale*j + scale
                };
                arr[i][j] = new Polygon(xArr , yArr, 6);
            }
        }

    }

    @Override
    public void draw(Graphics2D g2d) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                g2d.draw(arr[i][j]);
            }
        }
    }
}
