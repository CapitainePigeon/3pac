package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu  extends Application{

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Bienvenue sur 3pac, le pacman des bg");

        Button play = new Button();
        play.setText("Jouer");
        play.setTranslateY(100);
        play.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        Button quit = new Button();
        quit.setText("Quitter");
        quit.setTranslateY(150);
        quit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        Image img = new Image("File:src/ressources/3pac.png", 150, 150, false,false);
        ImageView tripac = new ImageView(img);
        tripac.setTranslateY(-150);

        StackPane root = new StackPane();
        root.getChildren().add(tripac);
        root.getChildren().add(label);
        root.getChildren().add(play);
        root.getChildren().add(quit);

        Scene scene = new Scene(root, 350, 500);

        primaryStage.setTitle("3PAC - Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}