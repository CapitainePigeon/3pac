package sample;

import java.util.Observable;

public class Jeu extends Observable implements Runnable
{
    @Override
    public void run() {
        while(true){
            setChanged();
            notifyObservers();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean[][] getState(){
        boolean [][] tab =new boolean[10][10];
        return tab;
    }
}
