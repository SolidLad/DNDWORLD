package generation;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Shape;
import java.util.ArrayList;
import java.util.Arrays;

public class TileGenerator {
    private Tile[] tiles;
    private Hex[] hexes;
    public TileGenerator(Tile[] tiles){
        this.tiles = tiles;
    }
    public TileGenerator(Hex[] hexes){
        this.hexes = hexes;
    }

    public void draw(GraphicsContext gc){
        if (tiles!=null){
            for (Tile tile : tiles) {
                tile.draw(gc);
            }
        }
        else {
            for (Hex hex : hexes) {
                hex.draw(gc);
            }
        }
    }
    public static Tile[] makeTiles(int x, int y, int width, int height, int scale){
        int tileWidth, tileHeight;
        tileHeight = height/scale;
        tileWidth = width/scale;
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < tileWidth; i++) {
            for (int j = 0; j < tileHeight; j++) {
                tiles.add(new Tile(x+scale*i,y+scale*j,scale));
            }
        }
        return tiles.toArray(new Tile[tiles.size()]);
    }
    public static Tile[] makeHexes(int x, int y, int width, int height, int scale){
        int hexWidth, hexHeight;
        double rootThree, yHalf;
        rootThree  = Math.sqrt(3);
        yHalf = rootThree * scale/2;
        ArrayList<Hex> hexes = new ArrayList<>();
        double combWidth = scale*3.5 + scale, combHeight = yHalf*4;
        hexWidth =(int)(width / combWidth)+1;
        hexHeight =(int)(height / combHeight)+1;
        for (int i = 0; i < hexWidth; i++) {
            for (int j = 0; j < hexHeight; j++) {
                if (i%2==0)
                    hexes.addAll(Hex.getHoneycomb(new Hex(x + combWidth*i, y + combHeight*j, scale)));
                else hexes.addAll(Hex.getHoneycomb(new Hex(x + combWidth*i, y + yHalf + combHeight*j, scale)));


            }
        }
        return hexes.toArray(new Hex[hexes.size()]);
    }
}
