package metier.jeuPacMan.cerveauDeFantominus;

import metier.jeuPacMan.Fantominus;
import metier.librairie.Case;
import metier.librairie.Entite;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;

import java.util.List;

public class Disjktra extends IAFantominus {
    private DijkstraShortestPath<Case, DefaultEdge> dij;
    private Entite cible;
    public Disjktra(GraphDesCouloirs graphDesCouloirs, Entite cible) {
        super(graphDesCouloirs);
        this.cible=cible;
        dij = new DijkstraShortestPath<>(grapheDesCouloir.graphe);
    }
    public List<Case> getCases(Fantominus fantominus){
        List<Case> liste= dij.getPath(fantominus.caseOccupe,cible.caseOccupe).getVertexList();

        if (liste.size()>1) {

            liste.remove(0);
        }
        return liste;
    }
}
