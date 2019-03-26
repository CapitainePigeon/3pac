package ViewController;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import metier.jeuPacMan.Fantominus;
import metier.jeuPacMan.Jeu;
import metier.jeuPacMan.PacMan;
import metier.jeuPacMan.cerveauDeFantominus.*;
import metier.librairie.Entite;

public class ControllerPacman {
    public ControllerPacman(Stage primaryStage, Jeu j,PacMan pacman) {
        GraphDesCouloirs graphDesCouloirs= new GraphDesCouloirs(j.grille);
        Random rdm =new Random(graphDesCouloirs);
        Sniffer sniffer =new Sniffer(graphDesCouloirs);
        FastRandom fastRdm =new FastRandom(graphDesCouloirs);
        Disjktra dij =new Disjktra(graphDesCouloirs,pacman);

        Fantominus fant1=new Fantominus(j.grille.getTab(11,12),rdm);
        Fantominus fant2=new Fantominus(j.grille.getTab(11,13),sniffer);
        Fantominus fant3=new Fantominus(j.grille.getTab(11,14),fastRdm);
        Fantominus fant4=new Fantominus(j.grille.getTab(11,15),dij);


        Thread f1 = new Thread(fant1);
        Thread f2 = new Thread(fant2);
        Thread f3 = new Thread(fant3);
        Thread f4 = new Thread(fant4);
        Thread p = new Thread(pacman);
        //PacMan pacman =new PacMan(j.grille.getTab(23,13));
        pacman.addObserver((o, arg) -> {
            if (pacman.isImmortel()){
                pacman.seCalmer();
                Fuite fuite =new Fuite(graphDesCouloirs);
                fant1.setIA(fuite);
                fant2.setIA(fuite);
                fant3.setIA(fuite);
                fant4.setIA(fuite);
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(15000);
                            fant1.setIA(rdm);
                            fant2.setIA(sniffer);
                            fant3.setIA(fastRdm);
                            fant4.setIA(dij);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });




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



        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(15000);
                    p.start();
                    Thread.sleep(1000);
                    f1.start();
                    Thread.sleep(1000);
                    f2.start();
                    Thread.sleep(1000);
                    f3.start();
                    Thread.sleep(1000);
                    f4.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        pacman.addObserver((o, arg) -> {
            if(pacman.isDead()) {
                System.out.println("t mort");
                fant1.kill();
                fant2.kill();
                fant3.kill();
                fant4.kill();

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Stage popupGO = new Stage();
                        Gameover go = new Gameover();
                        go.start(popupGO);
                        popupGO.show();
                        popupGO.setOnCloseRequest(new EventHandler<WindowEvent>() {
                            @Override
                            public void handle(WindowEvent e) {
                                primaryStage.close();
                            }
                        });
                    }
                });
            }
        });
    }
}
