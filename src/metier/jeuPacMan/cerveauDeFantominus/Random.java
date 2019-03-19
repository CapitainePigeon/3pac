package metier.jeuPacMan.cerveauDeFantominus;

import metier.jeuPacMan.Fantominus;
import metier.librairie.Case;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;

import java.util.List;

public class Random extends IAFantominus {
    private DijkstraShortestPath<Case, DefaultEdge> dij;
    private GraphDesCouloirs grapheDesCouloir;
    public Random(GraphDesCouloirs graphDesCouloirs) {
        //super(graphDesCouloirs);
        this.grapheDesCouloir=graphDesCouloirs;
        dij = new DijkstraShortestPath<>(grapheDesCouloir.graphe);
       // System.out.println(grapheDesCouloir.graphe.vertexSet().toArray()[rand]);
    }
    public List<Case> getCases(Fantominus fantominus){
        int rand= (int)(Math.random()*grapheDesCouloir.graphe.vertexSet().size());
        Case cible=(Case)grapheDesCouloir.graphe.vertexSet().toArray()[rand];
        List<Case> liste= dij.getPath(fantominus.caseOccupe,cible).getVertexList();
        if (liste.size()>1) {
            liste.remove(0);
        }
        return liste;
    }

    public String getFileImg(){
        return "fantominus_vert.png";
    }
}
