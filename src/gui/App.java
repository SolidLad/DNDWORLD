package gui;


import generation.Hex;
import generation.TileGenerator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ps) throws Exception {
        ps.setTitle("Dndood");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        GridPane input = new GridPane();
        input.setHgap(10);
        input.setVgap(10);
        input.setPadding(new Insets(0,0,0,0));

        ProgressBar pb = new ProgressBar(0);
        pb.setProgress(0.04);
        pb.setPrefWidth(600.0);

        Label label = new Label("Progress . . .");

        TextArea textArea = new TextArea("question here");
        textArea.setFocusTraversable(false);

        TextField textField = new TextField("input goes here");

        Button submit = new Button("Submit");
        submit.setPrefWidth(70);

        Button back = new Button("Back");
        back.setPrefWidth(70);

        Canvas canvas = new Canvas(600,450);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BROWN);
        gc.fillRect(0.0,0.0,600.0,600.0);
        gc.strokeText("map goes here",300.0,300.0);
        gc.setStroke(Color.DARKGRAY);
        gc.strokeRect(1,1,canvas.getWidth()-2,canvas.getHeight()-2);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0,0,canvas.getWidth(),canvas.getHeight());


//        TileGenerator tg = new TileGenerator(TileGenerator.makeTiles(0,0,(int)canvas.getWidth(),(int)canvas.getHeight(),12));
//        tg.draw(gc);

//        TileGenerator tg = new TileGenerator(TileGenerator.makeHexes(0,0,(int)canvas.getWidth(),(int)canvas.getHeight(),12));
//        tg.draw(gc);

        grid.add(label, 0, 0);
        grid.add(pb,2,0);
        grid.add(canvas, 2,1);

        input.add(textField,0,0,2,1);
        input.add(submit,0,1);
        input.add(back,1,1);

        grid.add(input, 0,2);
        grid.add(textArea, 0, 1);

        Scene scene = new Scene(grid, 1000,600);

        ps.setScene(scene);

        ps.show();
    }
}
