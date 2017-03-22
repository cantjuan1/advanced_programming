/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utadeo.programacion.avanzada.exposicion;

import java.util.ArrayList;

import co.edu.utadeo.programacion.avanzada.exposicion.graphviz.Route;

/**
 *
 * @author juan.cantor
 */
public class Graph {

    private final boolean node[];
    private final int MAX_NODES = 100;
    private final int edges[][];
    private final int distances[][];
    private final Route[] routes;

    public Graph() {
        node = new boolean[MAX_NODES];
        edges = new int[100][100];
        distances = new int[100][100];
        routes = new Route[MAX_NODES];
    }

    public void addNode(int id) throws NodeAlreadyExistsException, InvalidNodeIDException {
        if (id >= 0 && id < MAX_NODES) {
            if (!node[id]) {
                node[id] = true;
            } else {
                throw new NodeAlreadyExistsException("Ya existe el nodo!");
            }
        } else {
            throw new InvalidNodeIDException("Id no valido!");
        }
    }

    public void removeNode(int id) throws NodeDoesNotExistException {
        if (id >= 0 && id < MAX_NODES && node[id]) {
            node[id] = false;
            for (int i = 0; i < MAX_NODES; i++) {
                edges[i][id] = 0;
                edges[id][i] = 0;
                distances[i][id] = 0;
                distances[id][i] = 0;
            }
        } else {
            throw new NodeDoesNotExistException("No existe el nodo!");
        }
    }

    public void addEdge(int origin, int dest, int distance) throws NodeDoesNotExistException {
        if (node[origin] && node[dest]) {
            edges[origin][dest]++;
            distances[origin][dest] = distance;
        } else {
            throw new NodeDoesNotExistException("No existe el nodo!");
        }
    }

    public void removeEdge(int origin, int dest) throws EdgeDoesNotExistException {
        if (edges[origin][dest] > 0) {
            edges[origin][dest]--;
            distances[origin][dest] = 0;
        } else {
            throw new EdgeDoesNotExistException("No existe la arista!");
        }
    }

    public String displayGraph() {
        StringBuilder text = new StringBuilder();
//        String[] labels = {"", "A", "B", "C", "D", "E", "F"};
        String[] labels = {"", "v1", "v2", "v3", "v4", "v5", "v6", "v7"};
        text.append("graph G {\n");
        for (int i = 0; i < MAX_NODES; i++) {
            if (node[i]) {
                text.append(i).append(" [label=\"").append(labels[i]).append("\"];\n");
            }
        }
        for (int i = 0; i < MAX_NODES; i++) {
            for (int j = 0; j < MAX_NODES; j++) {
                for (int k = 0; k < edges[i][j]; k++) {
                    text.append(i).append("--").append(j).append(" [label=\"").append(distances[i][j]).append("\"];\n");
                }
            }
        }
        text.append("}");
        return text + "";
    }

    public boolean isEmpty() {
        for (int i = 0; i < MAX_NODES; i++) {
            if (node[i]) {
                return false;
            }
        }
        return true;
    }

    public int calculateInDegree(int id) {
        int countInDegree = 0;
        for (int j = 0; j < MAX_NODES; j++) {
            if (edges[j][id] > 0) {
                countInDegree += edges[j][id];
            }
        }
        return countInDegree;
    }

    public ArrayList<Integer> topSort() throws NodeDoesNotExistException {
        ArrayList<Integer> response = new ArrayList<Integer>();
        boolean notFoundNode = true;
        while (!isEmpty()) {
            for (int i = 0; i < MAX_NODES; i++) {
                if (node[i] && calculateInDegree(i) == 0) {
                    notFoundNode = false;
                    response.add(i);
                    removeNode(i);
                    break;
                }
            }
            if (notFoundNode) {
                throw new NodeDoesNotExistException("El grafo tiene ciclo!");
            }
            notFoundNode = true;
        }
        return response;
    }

    public int getEdgeDistance(int origin, int dest) throws EdgeDoesNotExistException {
        if (node[origin] && node[dest] && distances[origin][dest] > 0) {
            return distances[origin][dest];
        } else {
            throw new EdgeDoesNotExistException("No existe la arista!");
        }
    }

    public int getVerticeMinDistance() {
        int vertice = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < MAX_NODES; i++) {
            if (routes[i] != null && !routes[i].isKnown() && distance > routes[i].getDistance()) {
                distance = routes[i].getDistance();
                vertice = i;
            }
        }
        return vertice;
    }

    public void getDijkstraTable(int origin) throws EdgeDoesNotExistException {
        for (int i = 0; i < MAX_NODES; i++) {
            if (node[i]) {
                int distance = Integer.MAX_VALUE;
                if (i == origin) {
                    distance = 0;
                }
                routes[i] = new Route(i, false, distance, "-");
            }
        }
        int vertice = -1;
        do {
            vertice = getVerticeMinDistance();
            Route current = routes[vertice];
            for (int i = 0; i < MAX_NODES; i++) {
                if (node[i] && i != vertice && edges[vertice][i] > 0 && !routes[i].isKnown()) {
                    Route vecino = routes[i];
                    if (current.getDistance() + getEdgeDistance(vertice, i) < vecino.getDistance()) {
                        vecino.setDistance(current.getDistance() + getEdgeDistance(vertice, i));
                        vecino.setPreviousVertex(String.valueOf(vertice));
                    }

                }
            }
            if (vertice > 0) {
                routes[vertice].setKnown(true);
            }
        } while (vertice != 0);
    }

    public Graph getPrimGraph(int origin) throws EdgeDoesNotExistException, NodeAlreadyExistsException, InvalidNodeIDException, NodeDoesNotExistException {
        Graph objG = new Graph();
        for (int i = 0; i < MAX_NODES; i++) {
            if (node[i]) {
                int distance = Integer.MAX_VALUE;
                if (i == origin) {
                    distance = 0;
                }
                routes[i] = new Route(i, false, distance, "0");
            }
        }
        int vertice = -1;
        boolean isFirts = true;
        do {
            vertice = getVerticeMinDistance();
            if (vertice > 0) {
                routes[vertice].setKnown(true);
                objG.addNode(vertice);
            }
            Route current = routes[vertice];
            if (!isFirts && current != null) {
                objG.addEdge(vertice, Integer.parseInt(current.getPreviousVertex()), getEdgeDistance(vertice, Integer.parseInt(current.getPreviousVertex())));
                objG.addEdge(Integer.parseInt(current.getPreviousVertex()), vertice, getEdgeDistance(vertice, Integer.parseInt(current.getPreviousVertex())));
            }
            isFirts = false;
            for (int i = 0; i < MAX_NODES; i++) {
                if (node[i] && i != vertice && edges[vertice][i] > 0 && !routes[i].isKnown()) {
                    Route vecino = routes[i];
                    if (getEdgeDistance(vertice, i) < vecino.getDistance()) {
                        vecino.setDistance(getEdgeDistance(vertice, i));
                        vecino.setPreviousVertex(String.valueOf(vertice));
                    }

                }
            }
        } while (vertice != 0);
        return objG;
    }

    public int totalCost() throws EdgeDoesNotExistException {
        int totalDistance = 0;
        for (int i = 0; i < MAX_NODES; i++) {
            for (int j = i; j < MAX_NODES; j++) {
                if (node[i] && node[j] && edges[i][j] > 0) {
                    totalDistance += getEdgeDistance(i, j);
                }
            }
        }
        return totalDistance;
    }

    public void printDijkstraTable() {
        System.out.println("VERTICE\tknown\tdv\tpv");
        for (Route route : routes) {
            if (route != null) {
                System.out.println(route.getVertex() + "\t" + route.isKnown() + "\t" + route.getDistance() + "\t" + route.getPreviousVertex());
            }
        }
    }

    public static void main(String[] args) throws NodeAlreadyExistsException, InvalidNodeIDException, NodeDoesNotExistException, EdgeDoesNotExistException {
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
        String gr = objGAux.displayGraph();
        System.out.println(gr);
        int tca = objGAux.totalCost();
        System.out.println("total: " + tc);
        System.out.println("total optimo: " + tca);
        objG.getDijkstraTable(6);
        objG.printDijkstraTable();
    }
}
