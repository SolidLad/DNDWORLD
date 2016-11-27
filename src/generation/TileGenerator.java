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
        hexHeight = (int)(height/(yHalf*2));
        hexWidth = width/scale;
        ArrayList<Hex> hexes = new ArrayList<>();
        double honeyWidth = scale*3.5, honeyHeight = yHalf*4;
        for (int i = 0; i < hexWidth+1; i++) {
            for (int j = 0; j < hexHeight+1; j++) {
                // FIXME: 11/27/2016 This doesnt work lol
                hexes.addAll(Hex.getHoneycomb(new Hex(x + honeyWidth*i, y + honeyHeight*j, scale)));
            }
        }
        return hexes.toArray(new Hex[hexes.size()]);
    }
}
