package sample;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Menu  extends Application{

    boolean jeuEnCours=false;

    @Override
    public void start(Stage primaryStage) {


        Label labelEnCours = new Label("Jeu en cours...");
        labelEnCours.setTranslateY(135);
        labelEnCours.setVisible(false);
        Label label = new Label("Bienvenue sur 3pac, le pacman des bg");
        Button play = new Button();
        play.setText("Jouer");
        play.setTranslateY(100);
        play.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(!jeuEnCours) {
                    System.out.println("Play Pacman");
                    labelEnCours.setVisible(true);
                    Stage leJeuStage = new Stage();
                    Main leJeu = new Main();
                    leJeu.start(leJeuStage);
                    leJeuStage.show();
                    jeuEnCours = true;

                    leJeuStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                        @Override
                        public void handle(WindowEvent e) {
                            jeuEnCours=false;
                            System.out.println("Pacman closed");
                            labelEnCours.setVisible(false);
                        }
                    });
                }
                else
                    System.out.println("Pacman already playing");
            }
        });



        Button quit = new Button();
        quit.setText("Quitter");
        quit.setTranslateY(175);
        quit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        Image img = new Image("File:src/ressources/3pac.png", 150, 150, false,false);
        ImageView tripac = new ImageView(img);
        tripac.setTranslateY(-150);

        StackPane root = new StackPane();
        root.getChildren().add(tripac);
        root.getChildren().add(label);
        root.getChildren().add(labelEnCours);
        root.getChildren().add(play);
        root.getChildren().add(quit);

        Scene scene = new Scene(root, 350, 500);

        primaryStage.setTitle("3PAC - Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}