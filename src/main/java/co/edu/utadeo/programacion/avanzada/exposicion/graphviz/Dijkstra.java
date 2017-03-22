package co.edu.utadeo.programacion.avanzada.exposicion.graphviz;

import co.edu.utadeo.programacion.avanzada.exposicion.EdgeDoesNotExistException;
import co.edu.utadeo.programacion.avanzada.exposicion.InvalidNodeIDException;
import co.edu.utadeo.programacion.avanzada.exposicion.NodeAlreadyExistsException;
import co.edu.utadeo.programacion.avanzada.exposicion.NodeDoesNotExistException;

public class Dijkstra {

    private final boolean node[];
    private final int MAX_NODES = 100;
    private final int edges[][];
    private final int distances[][];
    private final Route[] routes;

    public Dijkstra() {
        node = new boolean[MAX_NODES];
        edges = new int[100][100];
        distances = new int[100][100];
        routes = new Route[MAX_NODES];
    }

    private int getVerticeMinDistance() {
        int vertice = 0;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < MAX_NODES; i++) {
            if (routes[i] != null && !routes[i].isKnown()
                    && distance > routes[i].getDistance()) {
                distance = routes[i].getDistance();
                vertice = i;
            }
        }
        return vertice;
    }

    private int getEdgeDistance(int origin, int dest)
            throws EdgeDoesNotExistException {
        if (node[origin] && node[dest] && distances[origin][dest] > 0) {
            return distances[origin][dest];
        }
        else {
            throw new EdgeDoesNotExistException("No existe la arista!");
        }
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
    
    public void addEdge(int origin, int dest, int distance) throws NodeDoesNotExistException {
        if (node[origin] && node[dest]) {
            edges[origin][dest]++;
            distances[origin][dest] = distance;
        } else {
            throw new NodeDoesNotExistException("No existe el nodo!");
        }
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
                if (node[i] && i != vertice && edges[vertice][i] > 0
                        && !routes[i].isKnown()) {
                    Route vecino = routes[i];
                    if (current.getDistance()
                            + getEdgeDistance(vertice, i) < vecino
                                    .getDistance()) {
                        vecino.setDistance(current.getDistance()
                                + getEdgeDistance(vertice, i));
                        vecino.setPreviousVertex(String.valueOf(vertice));
                    }

                }
            }
            if (vertice > 0) {
                routes[vertice].setKnown(true);
            }
        }
        while (vertice != 0);
    }
    
    public void printDijkstraTable() {
        System.out.println("VERTICE\tknown\tdv\tpv");
        for (Route route : routes) {
            if (route != null) {
                System.out.println(route.getVertex() + "\t" + route.isKnown() + "\t" + route.getDistance() + "\t" + route.getPreviousVertex());
            }
        }
    }

    public static void main(String arg[]) throws NodeDoesNotExistException, NodeAlreadyExistsException, InvalidNodeIDException, EdgeDoesNotExistException {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.addNode(1);//A
        dijkstra.addNode(2);//B
        dijkstra.addNode(3);//C
        dijkstra.addNode(4);//D
        dijkstra.addNode(5);//E
        dijkstra.addNode(6);//F
        dijkstra.addEdge(1, 2, 6);
        dijkstra.addEdge(1, 3, 9);
        dijkstra.addEdge(1, 4, 11);
        dijkstra.addEdge(1, 5, 5);
        dijkstra.addEdge(1, 6, 9);
        dijkstra.addEdge(2, 1, 6);
        dijkstra.addEdge(2, 3, 3);
        dijkstra.addEdge(2, 4, 6);
        dijkstra.addEdge(2, 5, 5);
        dijkstra.addEdge(2, 6, 2);
        dijkstra.addEdge(3, 1, 9);
        dijkstra.addEdge(3, 2, 3);
        dijkstra.addEdge(3, 5, 4);
        dijkstra.addEdge(3, 6, 4);
        dijkstra.addEdge(4, 1, 11);
        dijkstra.addEdge(4, 2, 6);
        dijkstra.addEdge(4, 5, 5);
        dijkstra.addEdge(4, 6, 6);
        dijkstra.addEdge(5, 1, 5);
        dijkstra.addEdge(5, 2, 5);
        dijkstra.addEdge(5, 3, 4);
        dijkstra.addEdge(5, 4, 5);
        dijkstra.addEdge(5, 6, 8);
        dijkstra.addEdge(6, 1, 9);
        dijkstra.addEdge(6, 2, 2);
        dijkstra.addEdge(6, 3, 4);
        dijkstra.addEdge(6, 4, 6);
        dijkstra.addEdge(6, 5, 8);
        dijkstra.getDijkstraTable(6);
        dijkstra.printDijkstraTable();
    }
}
