package gui;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
