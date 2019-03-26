package ViewController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import metier.jeuPacMan.Jeu;
import metier.jeuPacMan.PacMan;
import metier.librairie.Case;

import java.util.Observable;
import java.util.Observer;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage){

        Jeu j=new Jeu();

        BorderPane border = new BorderPane();

        // permet de placer les diffrents boutons dans une grille
        GridPane gPane = new GridPane();

        int column = 0;
        int row = 0;

        // création des bouton et placement dans la grille
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


        PacMan pacman =new PacMan(j.grille.getTab(23,13));




        gPane.setGridLinesVisible(false);

        StackPane voletScore = new StackPane();

        Image bgScoreImg = new Image("File:src/ressources/score.png", 200, 620, false,false);
        ImageView bgScore = new ImageView(bgScoreImg);
        voletScore.getChildren().add(bgScore);

        Label labelScore = new Label("");
        int scorePM = 0;
        pacman.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                int scorePM=10*pacman.getSuperPacGommeMangé()+pacman.getPacGommeMangé();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        labelScore.setText(String.valueOf(scorePM));
                    }
                });
            }
        });
        System.out.println(scorePM);
        labelScore.setTextFill(Color.web("#ff0000"));
        labelScore.setScaleX(4);
        labelScore.setScaleY(4);
        labelScore.setText(String.valueOf(scorePM));
        voletScore.getChildren().add(labelScore);

        border.setRight(voletScore);
        border.setCenter(gPane);

        primaryStage.setTitle("3PAC");
        primaryStage.setScene(new Scene(border, (28*20)+200, 31*20));
        primaryStage.show();

        new ControllerPacman(primaryStage,j,pacman);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
