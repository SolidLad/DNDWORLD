package gui;


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

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param ps the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage ps) throws Exception {
        ps.setTitle("Dndood");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        ProgressBar pb = new ProgressBar(0);
        pb.setProgress(0.04);
        pb.setPrefWidth(600.0);

        Label label = new Label("Progress . . .");

        TextArea textArea = new TextArea("question here");
        textArea.setFocusTraversable(false);

        TextField textField = new TextField("input goes here");

        Button button = new Button("Submit");
        button.setPrefWidth(350);

        Canvas canvas = new Canvas(600,450);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BROWN);
        gc.fillRect(0.0,0.0,600.0,600.0);
        gc.strokeText("map goes here",300.0,300.0);

        grid.add(label, 0, 0);
        grid.add(pb,2,0);
        grid.add(canvas, 2,1);
        grid.add(button, 0, 4);
        grid.add(textField,0,2);
        grid.add(textArea, 0, 1);

        Scene scene = new Scene(grid, 1000,600);
        ps.setScene(scene);

        ps.show();
    }
}
