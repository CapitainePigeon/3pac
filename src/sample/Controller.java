package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import metier.jeuPacMan.Jeu;

import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {

    public GridPane mainPane;
    TextArea b;
    public void initialize(){
        j=new Jeu();
        b=new TextArea();
        b.setText("caca");
        mainPane.add(b,0,0);
        j.addObserver(this);
        new Thread(j).start();
       // Image
    }
    Jeu j;
    @Override
    public void update(Observable o, Object arg) {
        b.setText(j.toString());
    }
}
