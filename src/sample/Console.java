package sample;

import Librairie.Case;

import java.util.Observable;
import java.util.Observer;

public class Console implements Observer {
    Jeu j;

    public Console(Jeu j) {
        this.j = j;
    }

    @Override
    public void update(Observable o, Object arg) {
        Case[][] tab=j.getState();
        for(int i=0;i<tab.length;i++){
            for(int k=0;k<tab[i].length;k++){
                System.out.print("|"+tab[i][k]);
            }
            System.out.println();
        }
        System.out.println("\n\n\n");
    }
}
