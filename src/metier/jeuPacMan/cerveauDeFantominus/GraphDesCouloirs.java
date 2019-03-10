package metier.jeuPacMan.cerveauDeFantominus;

import metier.librairie.Case;
import metier.librairie.Grille;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import static metier.librairie.Entite.Dir.*;


public class GraphDesCouloirs {
    //private DijkstraShortestPath a= new DijkstraShortestPath ();
    public SimpleGraph <Case, DefaultEdge>graphe;
    public GraphDesCouloirs(Grille grille) {
        graphe=new SimpleGraph<>(DefaultEdge.class);
        for(int ligne = 1; ligne < grille.getTab().length-1; ligne++) {
            for (int colone = 1; colone < grille.getTab()[0].length-1; colone++) {
                if (!grille.getTab(ligne,colone).isWall())
                {
                    graphe.addVertex(grille.getTab(ligne,colone));
                }
            }
        }
        for(int ligne = 1; ligne < grille.getTab().length-1; ligne++) {
            for (int colone = 1; colone < grille.getTab()[0].length-1; colone++) {
                if (!grille.getTab(ligne,colone).isWall())
                {
                    if(grille.getTab(ligne,colone).getVoisin(haut)!=null){
                        graphe.addEdge(grille.getTab(ligne,colone),grille.getTab(ligne,colone).getVoisin(haut));
                    }
                    if(grille.getTab(ligne,colone).getVoisin(bas)!=null){
                        graphe.addEdge(grille.getTab(ligne,colone),grille.getTab(ligne,colone).getVoisin(bas));
                    }
                    if(grille.getTab(ligne,colone).getVoisin(gauche)!=null){
                        graphe.addEdge(grille.getTab(ligne,colone),grille.getTab(ligne,colone).getVoisin(gauche));
                    }
                    if(grille.getTab(ligne,colone).getVoisin(droite)!=null){
                        graphe.addEdge(grille.getTab(ligne,colone),grille.getTab(ligne,colone).getVoisin(droite));
                    }
                }
            }
        }
    }
}
