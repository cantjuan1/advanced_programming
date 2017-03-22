/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utadeo.programacion.avanzada.exposicion.graphviz;

import co.edu.utadeo.programacion.avanzada.exposicion.EdgeDoesNotExistException;
import co.edu.utadeo.programacion.avanzada.exposicion.Graph;
import co.edu.utadeo.programacion.avanzada.exposicion.InvalidNodeIDException;
import co.edu.utadeo.programacion.avanzada.exposicion.NodeAlreadyExistsException;
import co.edu.utadeo.programacion.avanzada.exposicion.NodeDoesNotExistException;

/**
 *
 * @author usuario
 */
public class Graphviz {

    public void GenerateGraph() throws NodeAlreadyExistsException, InvalidNodeIDException, NodeDoesNotExistException, EdgeDoesNotExistException {
        Graph objG = new Graph();
        objG.addNode(1);//A
        objG.addNode(2);//B
        objG.addNode(3);//C
        objG.addNode(4);//D
        objG.addNode(5);//E
        objG.addNode(6);//F
        objG.addEdge(1, 2, 6);
        objG.addEdge(1, 3, 9);
        objG.addEdge(1, 4, 11);
        objG.addEdge(1, 5, 5);
        objG.addEdge(1, 6, 9);
        objG.addEdge(2, 1, 6);
        objG.addEdge(2, 3, 3);
        objG.addEdge(2, 4, 6);
        objG.addEdge(2, 5, 5);
        objG.addEdge(2, 6, 2);
        objG.addEdge(3, 1, 9);
        objG.addEdge(3, 2, 3);
        objG.addEdge(3, 5, 4);
        objG.addEdge(3, 6, 4);
        objG.addEdge(4, 1, 11);
        objG.addEdge(4, 2, 6);
        objG.addEdge(4, 5, 5);
        objG.addEdge(4, 6, 6);
        objG.addEdge(5, 1, 5);
        objG.addEdge(5, 2, 5);
        objG.addEdge(5, 3, 4);
        objG.addEdge(5, 4, 5);
        objG.addEdge(5, 6, 8);
        objG.addEdge(6, 1, 9);
        objG.addEdge(6, 2, 2);
        objG.addEdge(6, 3, 4);
        objG.addEdge(6, 4, 6);
        objG.addEdge(6, 5, 8);
        Graph objGAux = objG.getPrimGraph(1);
        int tc = objG.totalCost();
        int tca = objGAux.totalCost();
        String dotText = objGAux.displayGraph();
        System.out.println(dotText);
        String fileName = "tree_P.dot";
        System.out.println("costo total grafo: " + tc);
        System.out.println("costo total optimo: " + tca);
        Utils.writeFile(fileName, dotText);
        String imageName = "tree_P.png";
        GenerateDot(fileName, dotText, imageName);
        objG.getDijkstraTable(6);
        objG.printDijkstraTable();
    }
    
    private void GenerateDot(String fileName, String dotText, String imageName) {
        Utils.writeFile(fileName, dotText);
        Utils.execute("dot -Tpng " + fileName + " -o " + imageName);
        new ImageInJFrame().start(imageName);
    }

    public static void main(String arg[]) throws NodeAlreadyExistsException, InvalidNodeIDException, NodeDoesNotExistException, EdgeDoesNotExistException {
        Graphviz objG = new Graphviz();
        objG.GenerateGraph();
    }
}
