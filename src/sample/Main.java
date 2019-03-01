package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import metier.jeuPacMan.Jeu;
import metier.librairie.Case;

import java.io.IOException;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
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
                    String file="";
                    switch (o.toString()){
                        case "#":
                            file="mur.png";
                            break;
                        case " ":
                            file="couloir.png";
                            break;
                        case ".":
                            file="pacgomme.png";
                            break;
                        case "¤":
                            file="superpacgomme.png";
                            break;
                        case "O":
                            file="pacman.png";
                            break;
                        case "M":
                            file="fantominus.png";
                            break;
                    }
                    ((Case)o).getImgview().setImage(new Image("File:src/ressources/"+file,
                            20,20,false,false));
                });
               uneCase.aChangé();
            }
            column = 0;
            row++;
        }

        gPane.setGridLinesVisible(false);

        border.setCenter(gPane);

        primaryStage.setTitle("3Pac");
        primaryStage.setScene(new Scene(border, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
      /* Jeu j=new Jeu();
        Console c =new Console(j);
        //j.addObserver(c);
        new Thread(j).start();
       /* Controller controller =new Controller();
        controller.initialize();
        j.addObserver(c);*/
        launch(args);
    }
}
