package sample;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import metier.jeuPacMan.Fantominus;
import metier.jeuPacMan.Jeu;
import metier.jeuPacMan.PacMan;
import metier.jeuPacMan.cerveauDeFantominus.GraphDesCouloirs;
import metier.jeuPacMan.cerveauDeFantominus.Sniffer;
import metier.librairie.Entite;

public class ControllerPacman {
    public ControllerPacman(Stage primaryStage, Jeu j) {
        PacMan pacman =new PacMan(j.grille.getTab(23,13));
        pacman.addObserver((o, arg) -> {
            System.out.println("wallah t mort");
            //System.exit(0);
            //((PacMan)o).getImgview().setImage(new Image("File:src/ressources/"+((Case)o).getFileImg(),20,20,false,false));
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

        GraphDesCouloirs graphDesCouloirs= new GraphDesCouloirs(j.grille);
        Sniffer rdm =new Sniffer(graphDesCouloirs);

        Fantominus fant1=new Fantominus(j.grille.getTab(11,12),rdm);
        Fantominus fant2=new Fantominus(j.grille.getTab(11,13),rdm);
        Fantominus fant3=new Fantominus(j.grille.getTab(11,14),rdm);
        Fantominus fant4=new Fantominus(j.grille.getTab(11,15),rdm);
        new Thread(fant1).start();
        new Thread(fant2).start();
        new Thread(fant3).start();
        new Thread(fant4).start();
        new Thread(pacman).start();
    }
}
