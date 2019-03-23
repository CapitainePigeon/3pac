package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import metier.jeuPacMan.Jeu;
import metier.librairie.Case;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        Jeu j=new Jeu();
        BorderPane border = new BorderPane();
        GridPane gPane = new GridPane();
        int column = 0;
        int row = 0;

        for (Case[] ligne : j.getState()) {
            for (Case uneCase : ligne) {
                uneCase.setImgview(new ImageView());
                gPane.add(uneCase.getImgview(), column++, row);
                uneCase.addObserver((o, arg) -> {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            ((Case)o).getImgview().setImage(new Image("File:src/ressources/"+((Case)o).getFileImg(),
                                    20,20,false,false));
                        }
                    });
                });
               uneCase.aChangé();
            }
            column = 0;
            row++;
        }
        gPane.setGridLinesVisible(false);
        border.setCenter(gPane);

        primaryStage.setTitle("3Pac");
        primaryStage.setScene(new Scene(border, 28*20, 31*20));
        primaryStage.show();
        new ControllerPacman(primaryStage,j);

    }


    public static void main(String[] args) {

        launch(args);

    }
}
