package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import metier.jeuPacMan.Fantominus;
import metier.jeuPacMan.Jeu;
import metier.jeuPacMan.PacMan;
import metier.jeuPacMan.cerveauDeFantominus.GraphDesCouloirs;
import metier.jeuPacMan.cerveauDeFantominus.Sniffer;
import metier.librairie.Case;
import metier.librairie.Entite;

import java.util.Observable;
import java.util.Observer;

public class Main extends Application {

    boolean gameOver = false;

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


        GraphDesCouloirs graphDesCouloirs= new GraphDesCouloirs(j.grille);
        Sniffer rdm =new Sniffer(graphDesCouloirs);

        gPane.setGridLinesVisible(false);

        StackPane voletScore = new StackPane();
        Label labelScore = new Label("");
        int scorePM = pacman.getPacGommeMangé()+10*pacman.getSuperPacGommeMangé();
        pacman.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                int scorePM=pacman.getPacGommeMangé()+10*pacman.getSuperPacGommeMangé();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        labelScore.setText("Score = "+scorePM);
                    }
                });
            }
        });
        System.out.println(scorePM);
        labelScore.setText("Score = "+scorePM);
        voletScore.getChildren().add(labelScore);

        border.setRight(voletScore);



        border.setCenter(gPane);

        primaryStage.setTitle("3PAC");
        primaryStage.setScene(new Scene(border, (28*20)+200, 31*20));
        primaryStage.show();
        primaryStage.getScene().setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    @Override
                    public void handle(KeyEvent event) {
                        switch (event.getCode()) {
                            case UP:
                                pacman.changeDir(Entite.Dir.haut);
                                break;
                            case DOWN:
                                pacman.changeDir(Entite.Dir.bas);
                                break;
                            case LEFT:
                                pacman.changeDir(Entite.Dir.gauche);
                                break;
                            case RIGHT:
                                pacman.changeDir(Entite.Dir.droite);
                                break;
                        }
                    }
                });
        //primaryStage.setOnCloseRequest(event -> );

        Fantominus fant1=new Fantominus(j.grille.getTab(11,12),rdm);
        Fantominus fant2=new Fantominus(j.grille.getTab(11,13),rdm);
        Fantominus fant3=new Fantominus(j.grille.getTab(11,14),rdm);
        Fantominus fant4=new Fantominus(j.grille.getTab(11,15),rdm);
        Thread f1 = new Thread(fant1);
        f1.start();
        Thread f2 = new Thread(fant2);
        f2.start();
        Thread f3 = new Thread(fant3);
        f3.start();
        Thread f4 = new Thread(fant4);
        f4.start();
        Thread p = new Thread(pacman);
        p.start();
        pacman.addObserver((o, arg) -> {
            if(pacman.isDead()) {
                System.out.println("t mort");

                fant1.kill();
                fant2.kill();
                fant3.kill();
                fant4.kill();
            /*

            Stage popupGO = new Stage();
            Main go = new Main();
            go.start(popupGO);
            popupGO.show();
            */
            }
            //System.exit(0);
            //((PacMan)o).getImgview().setImage(new Image("File:src/ressources/"+((Case)o).getFileImg(),20,20,false,false));
        });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
