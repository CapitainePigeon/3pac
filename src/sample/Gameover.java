package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Gameover  extends Application{

    @Override
    public void start(Stage primaryStage) {



        Label label = new Label("GAME OVER");


        Button quit = new Button();
        quit.setText("Quitter");
        quit.setTranslateY(175);
        quit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(label);
        root.getChildren().add(quit);

        Scene scene = new Scene(root, 350, 500);

        primaryStage.setTitle("3PAC - Fin de partie");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}